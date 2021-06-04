package com.noah.chainResponsibility;

import com.noah.chainResponsibility.pojo.Msg;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author noah
 * @Date 5/31/21 10:47 PM
 * @Version 1.0
 **/
public class TestMain {
    public static void main(String[] args) {
        Msg msg = new Msg();
        String url = "http://baidu.com,<script> 你好438";
        msg.setMsg(url);

        FilterChain filterChain = new FilterChain();
        filterChain.add(new URIFilter());
        filterChain.add(new ScriptFilter());
        filterChain.add(new NumFilter());

        filterChain.doFilter(msg);

        System.out.println(msg.getMsg());
    }


}
interface Filter{
    void doFilter(Msg m);
}

class FilterChain{
    List<Filter> filters = new ArrayList<>();
    public void add(Filter filter){
        filters.add(filter);
    }

    public void doFilter(Msg m){
        for (Filter filter : filters) {
            filter.doFilter(m);
        }
    }
}


class URIFilter implements Filter{
    @Override
    public void doFilter(Msg m) {
        String url = m.getMsg();
        url = url.replace("http://baidu.com","http://tinto.top");
        m.setMsg(url);
    }
}

class ScriptFilter implements Filter{
    @Override
    public void doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replace("<","[").replace(">","]");
        m.setMsg(msg);
    }
}

class NumFilter implements Filter{
    @Override
    public void doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replace("438","小宝贝");
        m.setMsg(msg);
    }
}
