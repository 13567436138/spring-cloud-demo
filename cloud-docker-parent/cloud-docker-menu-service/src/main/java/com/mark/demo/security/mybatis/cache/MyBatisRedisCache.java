package com.mark.demo.security.mybatis.cache;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheKey;

import com.mark.demo.security.entity.Menu;
import com.mark.demo.security.service.CommonRedisFeignService;
import com.mark.demo.security.service.MenuRedisFeignService;
import com.mark.demo.security.utils.SpringUtils;

/*
*hxp(hxpwangyi@126.com)
*2017年9月8日
*
*/
public class MyBatisRedisCache implements Cache,Serializable{
	public static final String mybatis_cache_prefix="mybatis_cache";

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private String id;
	
	private CommonRedisFeignService commonRedisFeignService;
	
	private MenuRedisFeignService menuRedisFeignService;
	
	public CommonRedisFeignService getCommonRedisFeignService() {
		if(commonRedisFeignService==null){
			commonRedisFeignService=SpringUtils.getBean(CommonRedisFeignService.class);
		}
		return commonRedisFeignService;
	}

	public MenuRedisFeignService getMenuRedisFeignService() {
		if(menuRedisFeignService==null){
			menuRedisFeignService=SpringUtils.getBean(MenuRedisFeignService.class);
		}
		return menuRedisFeignService;
	}

	public MyBatisRedisCache(final String id) {
	    if (id == null) {
	        throw new IllegalArgumentException("缓存没有初始化id");
	    }
	    this.id = id;
	}

	@Override
	public String getId() {
	    return this.id;
	}

	@Override
	public int getSize() {
		
	    return getCommonRedisFeignService().getMapLen(mybatis_cache_prefix);
	}

	@Override
	public void putObject(Object key, Object value) {
		CacheKey cacheKey=(CacheKey)key;
		String [] keyAry=cacheKey.toString().split(":");
		String myKey=keyAry[2];
		if(value instanceof List){
			if(myKey.indexOf("MenuMapper")!=-1){
				getMenuRedisFeignService().setMapFieldMenu(mybatis_cache_prefix+myKey, cacheKey.toString(),(List<Menu>)value);
			}
		}
	}
	@Override
	public Object getObject(Object key) {
		CacheKey cacheKey=(CacheKey)key;
		String [] keyAry=cacheKey.toString().split(":");
		String myKey=keyAry[2];
	    return getCommonRedisFeignService().getMapFiled(mybatis_cache_prefix+myKey, cacheKey.toString());
	    
	}

	@Override
	public Object removeObject(Object key) {
		CacheKey cacheKey=(CacheKey)key;
		String [] keyAry=cacheKey.toString().split(":");
		String myKey=keyAry[2];
	    Object ret=getCommonRedisFeignService().getMapFiled(mybatis_cache_prefix+myKey, cacheKey.toString());
	    getCommonRedisFeignService().removeMapField(mybatis_cache_prefix+myKey,cacheKey.toString());
		return ret;
	}

	@Override
	public void clear() {
		getCommonRedisFeignService().del(mybatis_cache_prefix);
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
	    return readWriteLock;
	}

}
