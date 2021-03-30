package com.api;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreFilter extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		System.out.println("Pre filter");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		ctx.addZuulRequestHeader("Authorization", request.getHeader("Authorization"));
		ctx.addZuulRequestHeader("Authorization", request.getHeader("user"));
		System.out.println(request.getHeader("Authorization"));
		System.out.println(
				"Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURI().toString());

		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
