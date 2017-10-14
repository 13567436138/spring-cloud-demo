package com.mark.demo.security.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mark.demo.security.base.PaginateResult;
import com.mark.demo.security.base.Pagination;
import com.mark.demo.security.entity.Menu;
import com.mark.demo.security.service.MenuService;

/*
*hxp(hxpwangyi@126.com)
*2017年9月7日
*
*/
@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/getMenuTopLever")
	public List<Menu> getMenuTopLever(){
		return  menuService.getMenuTopLever();
	}
	
	@RequestMapping("/getMenuChildren")
	public List<Menu> getMenuChildren(int pid){
		return  menuService.getMenuChildren(pid);
	}
	
	@RequestMapping("/updateMenu")
	public boolean updateMenu(Menu menu){
		return menuService.updateMenu(menu);
	}
	
	@RequestMapping("/list/data")
	public PaginateResult<Menu> listData(@RequestBody Menu menu,@RequestBody Pagination pagination){
		return menuService.findPage(pagination, menu);
	}
}
