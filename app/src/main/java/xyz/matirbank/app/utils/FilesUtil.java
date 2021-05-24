package xyz.matirbank.app.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import xyz.matirbank.app.ThisApplication;

public class FilesUtil {

    public static File bitmapToFile(Bitmap bitmap, String fileNameToSave) {
        File file = null;
        try {
            file = new File(ThisApplication.getContext().getFilesDir() + File.separator + fileNameToSave);
            file.createNewFile();

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0 , bos);
            byte[] bitmapdata = bos.toByteArray();



            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            return file;
        }catch (Exception e){
            e.printStackTrace();
            return file;
        }
    }

}
