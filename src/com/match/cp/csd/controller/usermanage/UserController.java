package com.match.cp.csd.controller.usermanage;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 标准的rest方法列表
 * 
 * <pre>
 * /userinfo                index()  
 * /userinfo/new             _new()  注意: 不使用/userinfo/add =&gt; add()的原因是ad会被一些浏览器当做广告URL拦截
 * /userinfo/{id}           show()  
 * /userinfo/{id}/edit      edit()  
 * /userinfo        POST    create()  
 * /userinfo/{id}   PUT     update()  
 * /userinfo/{id}   DELETE  delete()  
 * /userinfo        DELETE  batchDelete()
 * </pre>
 * 
 * @author badqiu
 */

@Controller
@RequestMapping("/usermanage/*")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	/**注入service代码 */
	/**方法代码 */
	//GET对应查询, POST对应新增, PUT对应更新, DELETE对应删除 
    @RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
    @ResponseBody
    public int createUser(@PathVariable int id) throws IOException{
    	log.info(id+1+"aaa");
    	return id+1;
    }

}
