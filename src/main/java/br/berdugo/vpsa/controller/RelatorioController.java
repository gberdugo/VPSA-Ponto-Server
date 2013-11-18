package br.berdugo.vpsa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.berdugo.vpsa.enums.ReportType;
import br.berdugo.vpsa.enums.Status;
import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.pojo.relatorio.GeracaoRelatorioPojo;
import br.berdugo.vpsa.relatorios.registro.GeradorRelatorioRegistroFuncionarioAnalitico;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;
import br.berdugo.vpsa.utils.JSONReponse;

@Controller
@RequestMapping(value = "/relatorio")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class RelatorioController {
	
	@Autowired
	private IFuncionarioService funcionarioService;
	
	@Autowired
	private GeradorRelatorioRegistroFuncionarioAnalitico geradorRelatorioAnalitico;
	
	//@Autowired
	//private RelatorioRegistroHora

	@RequestMapping(value = "/gerar", method = RequestMethod.GET)
    public String gerarPage(ModelMap model) {
    	model.addAttribute("funcionarios", funcionarioService.listar());
    	
        return "/relatorio/gerar";
    }
	
	@RequestMapping(value = "/gerar", method = RequestMethod.POST)
	public void gerarRelatorio(@ModelAttribute("pojo") GeracaoRelatorioPojo pojo, HttpServletResponse response) {
		Map<String, Object> params = new HashMap<String, Object>();

		switch (pojo.getData()) {
			case ANALITICO: {
				//geradorRelatorioAnalitico.gerar(dados, params, pojo.getTipo(), response);
			} break;
			case SINTETICO: {
				
			} break;
		}
	}
	
	@ExceptionHandler
    @ResponseBody
    public JSONReponse handleException(Exception e) {
    	JSONReponse response = new JSONReponse();
    	
    	response.setStatus(Status.ERRO);
    	response.setRetorno(e);
    	response.setMensagem(e.getMessage());
    	
    	return response;
    }
}
