package com.hcmus.tinyscanner.lib.models;

/**
 * Created by danny on 1/2/2017.
 */

public class PageModel {
    public static String ID_COL = "id";
    public static String IMAGE_PATH_COL = "image_path";
    public static String ID_DOC_COL = "id_doc";

    private int id;
    private String imagePath;
    private int idDocument;

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
