package com.mark.demo.security.service;

import java.util.List;

import org.jsoup.Connection.Method;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mark.demo.security.base.HtmlWrapper;
import com.mark.demo.security.base.PaginateResult;
import com.mark.demo.security.entity.Menu;

/*
*hxp(hxpwangyi@126.com)
*2017年9月7日
*
*/
@FeignClient("menuService")
@RequestMapping("/service/menu")
public interface MenuFeignService {
	@RequestMapping("/getMenuTopLever")
	List<Menu> getMenuTopLever();
	@RequestMapping("/getMenuChildren")
	List<Menu> getMenuChildren(@RequestParam("pid")int pid);
	@RequestMapping("/updateMenu")
	boolean updateMenu(@RequestBody Menu menu);
	@RequestMapping(value="/list/data",method=RequestMethod.POST)
	PaginateResult<Menu> listData(@RequestBody Menu menu,@RequestParam("pageSize")int pageSize,@RequestParam("currentPage")int currentPage);
	
}	
