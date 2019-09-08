import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Tests {

	final static Logger logger = Logger.getLogger(Tests.class);

	@Before
	public void initTest() throws Exception {
		logger.info("Before");
	}

	@After
	public void closeTest() throws Exception {
		logger.info("After");
	}

	@Test
	public void testGetNames() throws Exception {
		logger.info("Test");
	}

}
