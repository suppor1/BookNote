package com.core.Test;


import com.ericsson.research.trap.impl.http.HTTPServlet25;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jiangkai
 * Date 2018/5/11
 */
public class HelloWordServlet extends HTTPServlet25 {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        while (classLoader != null){
            System.out.println(classLoader.getClass().getCanonicalName().toString());
            classLoader = classLoader.getParent();
        }
    }
}
