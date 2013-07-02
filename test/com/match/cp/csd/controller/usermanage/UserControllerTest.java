package com.match.cp.csd.controller.usermanage;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;

import com.match.cp.csd.controller.AbstractContextControllerTests;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest extends AbstractContextControllerTests{


	@Test
	public void createUser() throws Exception {
		MvcResult r = mvc.perform(delete("/usermanage/create/2")).andReturn();
		assertEquals("3",r.getResponse().getContentAsString());
        
	}

}
