package com.hcmus.tinyscanner.lib.utils;

import android.graphics.Bitmap;
import android.os.Environment;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by danny on 1/2/2017.
 */

public class FileUtil {
    public static File BASED_APP_DIR = Environment.getExternalStorageDirectory();
    public static String createDocumentDir(int idDoc) {
        Calendar rightNow = Calendar.getInstance();
        File mediaStorageDir = new File(BASED_APP_DIR, idDoc + "_" + rightNow.getTimeInMillis());
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        return mediaStorageDir.getAbsolutePath();
    }

    public static String savePage(String dirDoc, int idPage, Bitmap imageBitmap) {
        String pageName = idPage + "_" + Calendar.getInstance().getTimeInMillis() + ".png";
        String pagePath = new File(dirDoc, pageName).getAbsolutePath();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(pagePath);
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        } catch (Exception e) {
            pagePath = null;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pagePath;
    }

    public static boolean deletePage(String dirPage) {
        return new File(dirPage).delete();
    }

    public  static void deleteDocument(String dirDoc) {
        deleteRecursive(new File(dirDoc));
    }

    private static void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                deleteRecursive(child);
            }
        }
        fileOrDirectory.delete();
    }

    public static void exportPDF(String dirDoc, String dirName, List<String> imagePaths)  {
        Document document=new Document();
        try {
            PdfWriter.getInstance(document,new FileOutputStream("YourPDFHere.pdf"));
            document.open();
            for (String imagePath : imagePaths) {
                Image image = Image.getInstance (imagePath);
                document.add(new Paragraph(dirName));
                document.add(image);
            }
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
