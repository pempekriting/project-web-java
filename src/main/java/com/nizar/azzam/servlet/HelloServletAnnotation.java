package com.nizar.azzam.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlet-annotation", urlPatterns = {"/hello-annotation"})
public class HelloServletAnnotation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //language=HTML
        String html = "<!doctype html>\n" +
                "<html lang = \"en\" >\n" +
                "<head >" +
                "<meta charset = \"UTF-8\" >\n" +
                "<meta name = \"viewport\"\n"+
                "content = \"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\" > \n" +
                "<meta http -equiv = \"X-UA-Compatible\" content = \"ie=edge\" >\n" +
                "<title > Belajar Servlet </title >\n" +
                "</head >\n" +
                "<body >\n" +
                "<h3>Halloo! sedang belajar Servlet Annotation</h3>\n" +
                "</body >\n" +
                "</html >\n";
        resp.getWriter().print(html);
    }
}
