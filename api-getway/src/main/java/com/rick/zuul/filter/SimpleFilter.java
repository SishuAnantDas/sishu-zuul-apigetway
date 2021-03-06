package com.rick.zuul.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
//@Configuration
public class SimpleFilter extends ZuulFilter{

	private static final Logger LOGGER=LoggerFactory.getLogger(SimpleFilter.class);
	@Override
	public boolean shouldFilter() {
		RequestContext context=RequestContext.getCurrentContext();
		String param=context.getRequest().getParameter("deviceType");
		return param!=null && param.equals("BrokenDevice") ? true : true;
	}

	@Override
	public Object run() throws ZuulException {
		LOGGER.info("Inside  Simple Filter ");
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 5;
	}

}
