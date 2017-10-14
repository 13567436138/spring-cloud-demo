package com.mark.demo.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mark.demo.security.entity.Resource;
import com.mark.demo.security.service.ResourceService;

/*
*hxp(hxpwangyi@126.com)
*2017年10月14日
*
*/
@RestController
@RequestMapping("/service/resource")
public class ResourceController {
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/findAll")
	public List<Resource> findAll(){
		return resourceService.findAll();
	}
}
