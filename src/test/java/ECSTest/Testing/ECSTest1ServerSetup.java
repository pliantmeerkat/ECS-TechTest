package ECSTest.Testing;

import java.io.IOException;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ECSTest.Testing.lib.ECSTest1Setup;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ECSTest1Suite.class,
})
public class ECSTest1ServerSetup {
	
	private static Process p;

	@ClassRule
	public static ExternalResource setUpRule = new ExternalResource() {
		@Override
		protected void before() throws IOException {
			p = new ProcessBuilder("cmd", "/k", ECSTest1Setup.scriptPath + "\\yarnStart.sh").start();	
		}

		@Override
		protected void after() {
			p.destroy();
		}
	};
}
