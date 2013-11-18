package br.berdugo.vpsa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.berdugo.vpsa.suites.SuiteTestesUnitarios;

@RunWith(Suite.class)
@SuiteClasses({
	SuiteTestesUnitarios.class
	//SuiteIntegrationTest.class
})
public class SuitePrincipal {

}
