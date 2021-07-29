package com.nizar.azzam.request;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "servlet-handle-array", urlPatterns = {"/form-array"})
public class ServletHandleRequestArray extends HttpServlet {
    String html = "<!doctype html>\n" +
            "<html lang = \"en\" >\n" +
            "<head >" +
            "<meta charset = \"UTF-8\" >\n" +
            "<meta name = \"viewport\"\n" +
            "content = \"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\" > \n" +
            "<meta http -equiv = \"X-UA-Compatible\" content = \"ie=edge\" >\n" +
            "<title > Student Data </title >\n" +
            "</head >\n" +
            "<body >\n" +
            "<table>\n" +
            "<thead>\n " +
            "<tr>\n" +
            "<td>Student Registration Number</td>\n" +
            "<td>Name</td>\n" +
            "<td>City</td>\n" +
            "<td>Date of Birth</td>\n" +
            "<td>Hobby</td>\n"+
            "</tr>\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td>%s</td>\n" +
            "<td>%s</td>\n" +
            "<td>%s</td>\n" +
            "<td>%s</td>\n" +
            "<td>%s</td>\n" +
            "</table>\n" +
            "</body >\n" +
            "</html >\n";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String srn = req.getParameter("srn");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String dateOfBirth = req.getParameter("date-of-birth");
        String[] hobbies = req.getParameterValues("hobby");
        log.info("data GET: {nrm: {}, name: {}, city: {}, dateOfBirth: {}, hobby: {}}", srn, name, city, dateOfBirth, hobbies);

        String hobby = String.join(", ", hobbies);
        resp.getWriter().print(String.format(html, srn, name, city, dateOfBirth, hobby));
    }
}
