import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import testservice.configuration.AppConfig;
import testservice.configuration.AsyncConfiguration;
import testservice.controller.TaskController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, AsyncConfiguration.class })
public class Tests {

	final static Logger logger = Logger.getLogger(Tests.class);

	@Autowired
	TaskController controller;

	private MockMvc mockMvc;

	@Before
	public void initTest() throws Exception {
		logger.info("Before");
		this.mockMvc = standaloneSetup(controller).build();
	}

	@After
	public void closeTest() throws Exception {
		logger.info("After");
	}

	@Test
	public void homeTest() throws Exception {
		this.mockMvc.perform(get("/tasks")).andExpect(status().isOk());
		logger.info("Test");
	}


	@Test
	public void givenWac_whenServletContext_thenItProvidesGreetController() {
	}

}
