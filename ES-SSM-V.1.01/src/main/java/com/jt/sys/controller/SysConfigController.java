package com.jt.sys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;
@Controller
@RequestMapping("/config/")
public class SysConfigController {
	 @Autowired//按类型为属性注入值
	 private SysConfigService sysConfigService;
	 @RequestMapping(value="doFindPageObjects",produces="text/html;charset=utf-8")
	 @ResponseBody
	 public PageObject<SysConfig> doFindPageObjects(
			 String name,
			 Integer pageCurrent){
		 PageObject<SysConfig> pageObject=
		 sysConfigService.findPageObjects(name,
				 pageCurrent);
		 System.out.println(pageObject.getRecords());
		 return pageObject;
	 }
}
