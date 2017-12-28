package ru.naumen.springversioning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringVersioningApplicationTests {

	@Autowired
	WebApplicationContext webApplicationContext;

	@Test
	public void contextLoads() {
		MockMvc build = webAppContextSetup(webApplicationContext).build();

		int a = 3;
	}

}
