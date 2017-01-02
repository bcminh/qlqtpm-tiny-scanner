package com.hcmus.tinyscanner.lib.models;

import java.util.Date;

/**
 * Created by danny on 1/2/2017.
 */

public class DocumentModel {

    public static String ID_COL = "id";
    public static String NAME_COL = "name";
    public static String ORDER_COL = "order";
    public static String TIME_CREATED_COL = "create_time";
    public static String IMAGE_PATH_COL = "image_path";

    private int id;
    private String name;
    private String orders;
    private Date timeCreated;
    private String imagePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
