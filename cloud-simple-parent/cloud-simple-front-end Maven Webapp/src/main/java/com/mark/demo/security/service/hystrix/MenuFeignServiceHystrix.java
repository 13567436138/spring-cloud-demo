package com.mark.demo.security.service.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mark.demo.security.base.PaginateResult;
import com.mark.demo.security.entity.Menu;
import com.mark.demo.security.service.MenuFeignService;

/*
*hxp(hxpwangyi@126.com)
*2017年10月20日
*
*/
public class MenuFeignServiceHystrix implements MenuFeignService {
    private List<Menu> defaultList=new ArrayList<Menu>();
    private Throwable throwable;
	
    public MenuFeignServiceHystrix(Throwable throwable){
    	this.throwable=throwable;
    }
	@Override
	public List<Menu> getMenuTopLever() {
		return defaultList;
	}

	@Override
	public List<Menu> getMenuChildren(int pid) {
		return defaultList;
	}

	@Override
	public boolean updateMenu(Menu menu) {
		return false;
	}

	@Override
	public PaginateResult<Menu> listData(Menu menu, int pageSize, int currentPage) {
		PaginateResult<Menu> result=new PaginateResult<Menu>();
		result.setRows(defaultList);
		result.setTotal(0L);
		return result;
	}

}
