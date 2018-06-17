package com.example.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CustomZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10000;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();

        @SuppressWarnings("unchecked") Set<String> ignoredHeaders = (Set<String>) context.get("ignoredHeaders");
        ignoredHeaders.remove("authorization");
        ignoredHeaders.remove("Content-Type");


        return null;
    }
}
