package com.mark.demo.security.mybatis.cache;

import java.io.Serializable;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheKey;

import com.mark.demo.security.service.RedisFeignService;
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
	
	private RedisFeignService redisFeignService;

	public MyBatisRedisCache(final String id) {
	    if (id == null) {
	        throw new IllegalArgumentException("缓存没有初始化id");
	    }
	    this.id = id;
	    redisFeignService=SpringUtils.getBean("redisFeignService");
	}

	@Override
	public String getId() {
	    return this.id;
	}

	@Override
	public int getSize() {
		
	    return redisFeignService.getMapLen(mybatis_cache_prefix);
	}

	@Override
	public void putObject(Object key, Object value) {
		CacheKey cacheKey=(CacheKey)key;
		String [] keyAry=cacheKey.toString().split(":");
		String myKey=keyAry[2];
		redisFeignService.setMapField(mybatis_cache_prefix+myKey, cacheKey.toString(), value);
	}
	@Override
	public Object getObject(Object key) {
		CacheKey cacheKey=(CacheKey)key;
		String [] keyAry=cacheKey.toString().split(":");
		String myKey=keyAry[2];
	    return redisFeignService.getMapFiled(mybatis_cache_prefix+myKey, cacheKey.toString());
	    
	}

	@Override
	public Object removeObject(Object key) {
		CacheKey cacheKey=(CacheKey)key;
		String [] keyAry=cacheKey.toString().split(":");
		String myKey=keyAry[2];
	    Object ret=redisFeignService.getMapFiled(mybatis_cache_prefix+myKey, cacheKey.toString());
	    redisFeignService.removeMapField(mybatis_cache_prefix+myKey,cacheKey.toString());
		return ret;
	}

	@Override
	public void clear() {
		redisFeignService.del(mybatis_cache_prefix);
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
	    return readWriteLock;
	}

}
