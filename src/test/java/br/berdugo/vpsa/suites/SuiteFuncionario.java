package br.berdugo.vpsa.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.berdugo.vpsa.adapter.funcionario.GeradorRelatorioFuncionarioAdapterTest;
import br.berdugo.vpsa.validator.funcionario.FuncionarioValidatorTest;

@RunWith(Suite.class)
@SuiteClasses({
	FuncionarioValidatorTest.class,
	GeradorRelatorioFuncionarioAdapterTest.class
})
public class SuiteFuncionario {

}
