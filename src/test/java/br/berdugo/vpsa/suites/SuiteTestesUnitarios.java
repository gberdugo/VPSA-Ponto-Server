package br.berdugo.vpsa.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	SuiteFuncionario.class,
	SuiteRegistroFuncionario.class,
	SuiteUtils.class
})
public class SuiteTestesUnitarios {
	
}
