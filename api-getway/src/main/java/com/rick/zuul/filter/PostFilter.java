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
@Configuration
public class PostFilter extends ZuulFilter{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PostFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("In Post Filter");
		RequestContext context=RequestContext.getCurrentContext();
		
		HttpServletResponse response=context.getResponse();
		if (!response.equals(null)) {
			System.out.println("Response status code: "+response.getStatus());
			try(InputStream is=context.getResponseDataStream()) {
				String responseData=CharStreams.toString(new InputStreamReader(is, CharEncoding.UTF_8));
				System.out.println("Response Data: "+ responseData);
				context.setResponseBody(responseData);
			} catch (Exception e) {
				e.printStackTrace();
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
