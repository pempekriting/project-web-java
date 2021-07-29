package com.nizar.azzam.constant;

import java.io.File;

public class ConstantsData {
    private static final String PHOTOPATH = System.getProperty("user.dir") + File.separator +
            "src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "photo" + File.separator;

    public static String getPhotopath() {
        return PHOTOPATH;
    }
}
