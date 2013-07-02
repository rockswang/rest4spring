package com.match.cp.csd.controller.datacollect;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.match.cp.utils.JsonUtil;

/**
 * @author zhengfc
 * 数据采集时序(整体流程)
 * 1.
 * 2.
 * 3.
 * 4.
 * 5.
 * 6.
 * 7.
 * 8.
 * 9.
 * 10.
 */
@Controller
@RequestMapping("/datacollect/*")
public class FileUploadController {
	private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);
	
	@RequestMapping(value = "/fileupload/{username}/{password}/{companyId}/{handle}", 
			method = RequestMethod.GET)
    @ResponseBody
    public String fileupload(@PathVariable String username, @PathVariable String password, 
    		@PathVariable int companyId, @PathVariable Long handle,
    		HttpServletRequest request) throws IOException{
    	log.info("username-->>"+username+",password---->>"+password+",companyId---->>"+companyId+",handle---->>"+handle);
    	Map<String, Object> retMap = new HashMap<String, Object>();
    	retMap.put("result", true);
    	retMap.put("url", "http://localhost:8080/zhengfc");
    	retMap.put("ftpUserName", "zhengfc");
    	retMap.put("ftpPassword", "323");
    	
    	return JsonUtil.mapToJson(retMap);
    }
	
}
