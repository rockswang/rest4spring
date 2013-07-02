package com.match.cp.csd.controller.datacollect;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;

import com.match.cp.csd.controller.AbstractContextControllerTests;
@RunWith(SpringJUnit4ClassRunner.class)
public class FileUploadControllerTest extends AbstractContextControllerTests{
	
	@Test
	public void fileload() throws Exception {
		String url = "/datacollect/fileupload/zhengfc/323/201630/1";
		MvcResult r = mvc.perform(get(url)).andReturn();
		assertEquals("{\"result\":true,\"ftpPassword\":\"323\",\"ftpUserName\":\"zhengfc\",\"url\":\"http://localhost:8080/zhengfc\"}", r.getResponse().getContentAsString());
        
	}
}
