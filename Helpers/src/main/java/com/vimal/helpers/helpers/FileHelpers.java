/*
 * Copyright (C) 2021 Vimal Patel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vimal.helpers.helpers;

import android.os.Environment;

import java.io.File;

public class FileHelpers {


    public static File getFile(String dir, String path) {
        File file;
        try {
            String url = path;
            String file_name = url.substring(url.lastIndexOf('/'));
            file = new File(dir + file_name);
        } catch (StringIndexOutOfBoundsException e) {
            file = null;
        }
        return file;
    }

    public static void CreateFolder(String Foldername) {
        File imageDir = new File(Environment.getExternalStorageDirectory() + File.separator + Foldername);
        if (!imageDir.exists()) {
            imageDir.mkdirs();
        }
    }

    public static String getFolderPath(String foldername) {
        return Environment.getExternalStorageDirectory() + File.separator + foldername;
    }

    public static String getfilePath(File file) {
        return file.getAbsolutePath();
    }
}
