package com.alobosz.bitcoinbeetrack.util;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QrGenerator {
    public static Bitmap createQR(String data, int height, int width) {
        try {
            BitMatrix matrix = new MultiFormatWriter().encode(
                    data, BarcodeFormat.QR_CODE, width, height);
            return new BarcodeEncoder().createBitmap(matrix);

        } catch (WriterException | NullPointerException e) {
            return null;
        }
    }
}
