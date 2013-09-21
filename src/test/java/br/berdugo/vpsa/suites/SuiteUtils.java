package br.berdugo.vpsa.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.berdugo.vpsa.utils.CalendarUtilsTest;

@RunWith(Suite.class)
@SuiteClasses({
	CalendarUtilsTest.class
})
public class SuiteUtils {

}
