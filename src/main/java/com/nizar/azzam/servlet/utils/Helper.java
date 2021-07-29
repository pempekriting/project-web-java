package com.nizar.azzam.servlet.utils;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Helper {
    public static void savePhoto(String path, String fileName, Part photo) throws IOException {
        File location = new File(path);

        if (!location.exists()) {
            location.mkdirs();
        }

        assert fileName != null;
        File file = new File(location, fileName);
        try (InputStream stream = photo.getInputStream()) {
            Files.copy(stream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
}
