package br.berdugo.vpsa.adapter.funcionario;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.pojo.funcionario.FuncionarioRelatorioPojo;

public class GeradorRelatorioFuncionarioAdapterTest {

	private static final Long FUNCIONARIO_A_ID = 1L;
	private static final Long FUNCIONARIO_A_VPSA_ID = 1L;
	private static final String FUNCIONARIO_A_RFID = "1234";
	private static final String FUNCIONARIO_A_NOME = "NOME A";
	
	private static final Long FUNCIONARIO_B_ID = 2L;
	private static final Long FUNCIONARIO_B_VPSA_ID = 2L;
	private static final String FUNCIONARIO_B_RFID = "4321";
	private static final String FUNCIONARIO_B_NOME = "NOME B";
	
	private RelatorioFuncionarioAdapter adapter;
	
	@Before
	public void setup() {
		adapter = new RelatorioFuncionarioAdapter();
	}
	
	@Test
	public void deveRetornarUmaListaVaziaSeListaDeFuncionariosForNula() {
		List<FuncionarioRelatorioPojo> retorno = adapter.adapt(null);
		
		assertNotNull(retorno);
		assertTrue(retorno.isEmpty());
	}
	
	@Test
	public void deveAdaptarAListaDeFuncionarios() {
		List<FuncionarioRelatorioPojo> retorno = adapter.adapt(getFuncionarios());
		
		assertNotNull(retorno);
		assertFalse(retorno.isEmpty());
		assertFuncionarioA(retorno.get(0));
		assertFuncionarioB(retorno.get(1));
	}

	private void assertFuncionarioA(FuncionarioRelatorioPojo funcionario) {
		assertEquals(FUNCIONARIO_A_ID, funcionario.getId());
		assertEquals(FUNCIONARIO_A_NOME, funcionario.getNome());
		assertEquals(FUNCIONARIO_A_RFID, funcionario.getRfid());
	}
	
	private void assertFuncionarioB(FuncionarioRelatorioPojo funcionario) {
		assertEquals(FUNCIONARIO_B_ID, funcionario.getId());
		assertEquals(FUNCIONARIO_B_NOME, funcionario.getNome());
		assertEquals(FUNCIONARIO_B_RFID, funcionario.getRfid());
	}

	private List<Funcionario> getFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		Funcionario funcionarioA = new Funcionario();
		funcionarioA.setCodigoRFID(FUNCIONARIO_A_RFID);
		funcionarioA.setId(FUNCIONARIO_A_ID);
		funcionarioA.setIdVpsaRepresentante(FUNCIONARIO_A_VPSA_ID);
		funcionarioA.setNome(FUNCIONARIO_A_NOME);
		
		Funcionario funcionarioB = new Funcionario();
		funcionarioB.setCodigoRFID(FUNCIONARIO_B_RFID);
		funcionarioB.setId(FUNCIONARIO_B_ID);
		funcionarioB.setIdVpsaRepresentante(FUNCIONARIO_B_VPSA_ID);
		funcionarioB.setNome(FUNCIONARIO_B_NOME);
		
		funcionarios.add(funcionarioA);
		funcionarios.add(funcionarioB);
		
		return funcionarios;
	}
}
