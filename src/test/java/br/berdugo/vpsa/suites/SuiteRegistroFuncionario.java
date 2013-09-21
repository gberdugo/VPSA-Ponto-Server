package br.berdugo.vpsa.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.berdugo.vpsa.validator.registro.RegistroFuncionarioServiceTest;
import br.berdugo.vpsa.validator.registro.RegistroFuncionarioValidatorTest;

@RunWith(Suite.class)
@SuiteClasses({
	RegistroFuncionarioValidatorTest.class,
	RegistroFuncionarioServiceTest.class
})
public class SuiteRegistroFuncionario {

}
