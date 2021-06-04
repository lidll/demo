package com.noah.chainResponsibility.servletChain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author noah
 * @Date 5/31/21 11:08 PM
 * @Version 1.0
 **/
public class TestMain {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "request";
        Response response = new Response();
        response.str = "response";

        FilterChain filterChain = new FilterChain();
        filterChain.add(new AFilter());
        filterChain.add(new BFilter());
        filterChain.doFilter(request,response,filterChain);
    }
}

interface Filter{
    void doFilter(Request request,Response response,FilterChain filterChain);
}

class FilterChain implements Filter{
    List<Filter> filterList = new ArrayList<>();

    Integer index = 0;

    public void add(Filter filter){
        this.filterList.add(filter);
    }

    @Override
    public void doFilter(Request request, Response response,FilterChain filterChain) {
        if (index == filterList.size()) {
            return;
        }
        Filter filter = filterList.get(index);
        index ++;
        filter.doFilter(request,response,this);
    }
}

class AFilter implements Filter{
    @Override
    public void doFilter(Request request, Response response,FilterChain filterChain) {
        System.out.println("ARequest");
        filterChain.doFilter(request,response,filterChain);
        System.out.println("AResponse");
    }
}

class BFilter implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("BRequest");
        filterChain.doFilter(request,response,filterChain);
        System.out.println("BResponse");
    }
}

class Request{
    String str;
}

class Response{
    String str;
}
