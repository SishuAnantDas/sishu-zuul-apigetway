package com.rick.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Configuration
public class PreSecondFilter extends ZuulFilter{
	private static final Logger LOGGER=LoggerFactory.getLogger(PreSecondFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest request=context.getRequest();
		LOGGER.info("[PreSecondFilter] request method = {},url = {}", request.getMethod(),request.getRequestURL());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
