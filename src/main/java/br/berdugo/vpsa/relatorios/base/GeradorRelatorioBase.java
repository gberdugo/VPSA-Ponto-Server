package br.berdugo.vpsa.relatorios.base;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Logger;

import br.berdugo.vpsa.enums.ReportType;

public abstract class GeradorRelatorioBase {

	private static final Logger logger = Logger.getLogger(GeradorRelatorioBase.class);
	
	private static final String MEDIA_TYPE_EXCEL = "application/vnd.ms-excel";
	private static final String MEDIA_TYPE_PDF = "application/pdf";
	private static final String EXTENSION_TYPE_EXCEL = ".xls";
	private static final String EXTENSION_TYPE_PDF = ".pdf";
	
	public abstract String getReportPath();
	
	public abstract String getFilename();
	
	public void gerar(Collection<?> dados, Map<String, Object> params, ReportType type, HttpServletResponse response) {
		try {
			JRBeanCollectionDataSource datasource = createDataSource(dados);

			if (!params.containsKey("data")) {
				params.put("data", Calendar.getInstance());
			}
			
			InputStream reportStream = this.getClass().getResourceAsStream(getReportPath());
			
			JasperDesign jd = JRXmlLoader.load(reportStream);
			JasperReport jr = JasperCompileManager.compileReport(jd);
			JasperPrint jp = JasperFillManager.fillReport(jr, params, datasource);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			if (type.equals(ReportType.PDF)) {
				exportPdf(jp, reportStream, baos);
				
				String filename = getFilename() + new Date().getTime() + EXTENSION_TYPE_PDF;
				
				response.setHeader("Content-Disposition", "inline; filename=" + filename);
				
				response.setContentType(MEDIA_TYPE_PDF);
				response.setContentLength(baos.size());
				
				write(response, baos);
			} else if (type.equals(ReportType.XLS)) {
				exportXls(jp, reportStream, baos);
				
				String filename = getFilename() + new Date().getTime() + EXTENSION_TYPE_EXCEL;
				
				response.setHeader("Content-Disposition", "inline; filename=" + filename);
				
				response.setContentType(MEDIA_TYPE_EXCEL);
				response.setContentLength(baos.size());
				
				write(response, baos);
			}
		} catch (JRException exception) {
			logger.error("Erro ao processar o arquivo");
		}
	}

	private JRBeanCollectionDataSource createDataSource(Collection<?> dados) {
		return new JRBeanCollectionDataSource(dados);
	}

	private void exportPdf(JasperPrint jp, InputStream reportStream, ByteArrayOutputStream baos) {
		JRPdfExporter exporter = new JRPdfExporter();
		
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		
		try {
			exporter.exportReport();
		} catch (JRException exception) {
			throw new RuntimeException(exception);
		}
	}
	
	private void exportXls(JasperPrint jp, InputStream reportStream, ByteArrayOutputStream baos) {
		JRXlsExporter exporter = new JRXlsExporter();
		
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		
		exporter.setParameter(JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
		exporter.setParameter(JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		exporter.setParameter(JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		
		try {
			exporter.exportReport();
		} catch (JRException exception) {
			throw new RuntimeException(exception);
		}
	}
	
	private void write(HttpServletResponse response, ByteArrayOutputStream baos) {
		try {
			logger.debug(baos.size());
			
			ServletOutputStream outputStream = response.getOutputStream();
			
			baos.writeTo(outputStream);
			
			outputStream.flush();
		} catch (Exception exception) {
			logger.error("Erro ao escrever o arquivo.");
			throw new RuntimeException(exception);
		}
	}
}
