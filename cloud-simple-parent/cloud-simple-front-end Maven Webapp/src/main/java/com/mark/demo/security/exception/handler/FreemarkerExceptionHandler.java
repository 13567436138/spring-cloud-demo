package com.mark.demo.security.exception.handler;

import java.io.Writer;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/*
*hxp(hxpwangyi@126.com)
*2017年10月20日
*
*/
public class FreemarkerExceptionHandler implements TemplateExceptionHandler {

	@Override
	public void handleTemplateException(TemplateException te, Environment env, Writer out) throws TemplateException {
		te.printStackTrace();
		
	}

}
