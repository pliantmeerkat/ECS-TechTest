package ECSTest.Testing;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ECSTest.Testing.lib.ECSTest1Setup;

@RunWith(Suite.class)
@SuiteClasses({ECSTest1Test.class, ECSTest1FeatureTest.class})
public class ECSTest1ServerSetup {
	
	private static Process p;

	@BeforeClass
	public static void setUp() throws IOException {
		p = new ProcessBuilder("cmd", "/k", ECSTest1Setup.scriptPath + "\\yarnStart.sh").start();	
	}

	@AfterClass
	public static void tearDown() {
		p.destroy();
	}
}
