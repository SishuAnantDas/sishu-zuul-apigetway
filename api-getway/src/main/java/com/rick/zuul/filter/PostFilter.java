package com.rick.zuul.filter;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.rick.zuul.exception.ZullApiGetwayException;
@Configuration
public class PostFilter extends ZuulFilter{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PostFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context=RequestContext.getCurrentContext();
		
		HttpServletResponse response=context.getResponse();
		if (!response.equals(null)) {
			LOGGER.info("Response status = {}", response.getStatus());
			try(InputStream is=context.getResponseDataStream()) {
				String responseData=CharStreams.toString(new InputStreamReader(is, CharEncoding.UTF_8));
				LOGGER.info("Response Data = {}", responseData);
				//context.setResponseBody(responseData);//Filter threw Exception
				context.setResponseBody(responseData);
			} catch (Exception e) {
				throw new ZullApiGetwayException("Respose body not set");
			}
		}
		
		
		
	
		
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
