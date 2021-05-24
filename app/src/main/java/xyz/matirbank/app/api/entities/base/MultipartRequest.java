package xyz.matirbank.app.api.entities.base;

import android.graphics.Bitmap;

import java.io.File;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import xyz.matirbank.app.utils.FilesUtil;

public class MultipartRequest {

    MultipartBody.Part multiPart;

    public void addValue(String name, String value) {
        multiPart = MultipartBody.Part.createFormData(name, value);
    }

    public void addFile(String name, String fileName, File file) {
        multiPart = MultipartBody.Part.createFormData(name, fileName, RequestBody.create(file, MediaType.parse("image/*")));
    }

    public void addBitmap(String name, Bitmap bitmap) {
        String fileName = "temp_image.png";
        File file = FilesUtil.bitmapToFile(bitmap, fileName);
        multiPart = MultipartBody.Part.createFormData(name, fileName, RequestBody.create(file, MediaType.parse("image/*")));
    }

    public MultipartBody.Part getMultiPart() {
        return multiPart;
    }

}
