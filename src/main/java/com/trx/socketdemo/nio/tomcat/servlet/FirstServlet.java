package com.trx.socketdemo.nio.tomcat.servlet;

import com.trx.socketdemo.nio.tomcat.http.Request;
import com.trx.socketdemo.nio.tomcat.http.Response;
import com.trx.socketdemo.nio.tomcat.http.Servlet;

public class FirstServlet extends Servlet {
    @Override
    public void doGet(Request request, Response response) throws Exception {
        this.doPost(request,response);
    }

    @Override
    public void doPost(Request request, Response response) throws Exception {

        response.write("This is First Servlet");
    }
}
