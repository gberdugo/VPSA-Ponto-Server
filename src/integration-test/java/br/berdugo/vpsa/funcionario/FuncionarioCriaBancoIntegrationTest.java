package br.berdugo.vpsa.funcionario;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hsqldb.Database;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.berdugo.vpsa.service.interfaces.IFuncionarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_test.xml", "classpath:database_test.xml"} )
public class FuncionarioCriaBancoIntegrationTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private IFuncionarioService service;
	
	@Test
	public void criaBanco() throws Exception {
		dropaBanco();
		//insereDados("src/integration-test/java/xml/dados_basicos.xml");
	}
	
	private void dropaBanco() throws Exception {
		//DatabaseOperation.DELETE_ALL.execute(getConnection(), getDataSet());
	}

	private void insereDados() throws Exception {
		//DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
	}
	
	private IDatabaseConnection getConnection() throws Exception {
		Connection con = dataSource.getConnection();
		DatabaseMetaData databaseMetaData = con.getMetaData();
		IDatabaseConnection connection = new DatabaseConnection(con, databaseMetaData.getUserName().toUpperCase());
		
		return connection;
	}
	
	private IDataSet getDataSet(String filename) throws Exception {
		File file = new File(filename);
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		
		return builder.build(file);
	}

	@Test
	public void test() {
		service.buscarPorId(1L);
	}
}
