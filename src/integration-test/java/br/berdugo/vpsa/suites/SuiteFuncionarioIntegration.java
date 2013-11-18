package br.berdugo.vpsa.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.berdugo.vpsa.funcionario.FuncionarioCriaBancoIntegrationTest;
import br.berdugo.vpsa.funcionario.FuncionarioIntegrationTest;

@RunWith(Suite.class)
@SuiteClasses({
	//FuncionarioCriaBancoIntegrationTest.class
	FuncionarioIntegrationTest.class
})
public class SuiteFuncionarioIntegration {

}
