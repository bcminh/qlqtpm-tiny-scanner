package com.hcmus.tinyscanner.lib.services;

import org.opencv.android.OpenCVLoader;

/**
 * Created by danny on 1/2/2017.
 */

public class TinyScannerService {
    private static TinyScannerService instance; // singleton

    public TinyScannerService getInstance() {
        if (instance == null) {
            instance = new TinyScannerService();
        }
        return instance;
    }

    private TinyScannerService() {

    }
}
