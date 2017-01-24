package com.hcmus.tinyscanner.lib.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Scalar;

/**
 * Created by danny on 1/2/2017.
 */

public class ImageUtil {
    public static Bitmap rotateBitmap(Bitmap original, int angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(90);
        return Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
    }

    public static Mat bitmapToMat(Bitmap bitmap) {
        Mat mat = new Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U, new Scalar(4));
        Bitmap bitmap32 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Utils.bitmapToMat(bitmap32, mat);
        return mat;
    }

    public static Bitmap matToBitmap(Mat mat) {
        Bitmap bitmap = Bitmap.createBitmap(mat.cols(), mat.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(mat, bitmap);
        return bitmap;
    }

    public static MatOfPoint2f getRectangle(Mat srcMat){
        RectFinder rectFinder = new RectFinder(0.2, 0.98);
        MatOfPoint2f rectangle = rectFinder.findRectangle(srcMat);
        return rectangle;
    }

    public static Mat TransformRectangle(Mat srcMat, MatOfPoint2f rectangle){
        PerspectiveTransformation perspective = new PerspectiveTransformation();
        Mat dstMat = perspective.transform(srcMat, rectangle);
        return dstMat;
    }

    public static Bitmap Review(Bitmap bitmap){
        Mat srcMat = ImageUtil.bitmapToMat(bitmap);
        MatOfPoint2f rectangle = ImageUtil.getRectangle(srcMat);
        Mat des = TransformRectangle(srcMat,rectangle);
        Bitmap dest = matToBitmap(des);
        return dest;
    }
}
