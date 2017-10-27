package com.mark.demo.security.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.auth.BasicUserPrincipal;
import org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mark.demo.security.utils.SpringUtils;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.filters.StaticResponseFilter;

/*
*hxp(hxpwangyi@126.com)
*2017年10月27日
*
*/
public class CostomStaticResponseFilter extends StaticResponseFilter {

	public List<String> uri() {
		List<String> urlList=new ArrayList<String>();
		urlList.add("/health/");
		return urlList;
	}

	public Object responseBody(HttpServletRequest request,String uri) {
		switch (uri){
			case "/health/":
				HealthMvcEndpoint healthMvcEndpoint=SpringUtils.getBean(HealthMvcEndpoint.class);
				return healthMvcEndpoint.invoke(request, new BasicUserPrincipal("admin"));
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		String path = RequestContext.getCurrentContext().getRequest().getRequestURI();
        if (checkPath(path)) return true;
        if (checkPath("/" + path)) return true;
        return false;
	}
	
	public boolean checkPath(String path) {
        List<String> uriList = uri();
        if(uriList.contains(path)){
        	return true;
        }
        
        return false;
    }

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
        // Set the default response code for static filters to be 200
        ctx.setResponseStatusCode(HttpServletResponse.SC_OK);
        // first StaticResponseFilter instance to match wins, others do not set body and/or status
        if (ctx.getResponseBody() == null) {
        	String uri=ctx.getRequest().getRequestURI();
        	ObjectMapper mapper = new ObjectMapper(); 
        	String resp;
			try {
				resp = mapper.writeValueAsString(responseBody(ctx.getRequest(),uri));
				ctx.setResponseBody(resp);
	            ctx.setSendZuulResponse(false);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
            
        }
        return null;
	}


	@Override
	public String responseBody() {
		return null;
	}

}
