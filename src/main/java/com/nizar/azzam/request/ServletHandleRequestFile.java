package com.nizar.azzam.request;

import com.nizar.azzam.constant.ConstantsData;
import com.nizar.azzam.utils.Helper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@Slf4j
@WebServlet(name = "servlet-handle-file-request", urlPatterns = {"/form-file"})
public class ServletHandleRequestFile extends HttpServlet {

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
            "<td>Hobby</td>\n" +
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
        Part photo = req.getPart("photo");
        String submittedFileName = Helper.getSubmittedFileName(photo);
        log.info("data GET: {nrm: {}, name: {}, city: {}, dateOfBirth: {}, photo: {}}", srn, name, city, dateOfBirth, submittedFileName);
        Helper.savePhoto(ConstantsData.getPhotopath(),submittedFileName,photo);
        resp.getWriter().print(
                String.format(html, srn, name, city, dateOfBirth, submittedFileName)
        );
    }
}
