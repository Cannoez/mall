//package com.zeal.mall.util;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.WriterException;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
//import com.zeal.mall.common.Constant;
//
//import java.io.IOException;
//import java.nio.file.FileSystems;
//import java.nio.file.Path;
//
///**
// * @version: java version 1.8
// * @author: zeal
// * @description: 生成二维码的工具
// * @date: 2022-06-13 3:17
// */
//public class QRCodeGenerator {
//    //text可以换成支付的url
//    public static void generateQRCodeImage(String text,int width,int height,String filePath) throws WriterException, IOException {
//        QRCodeWriter qrCodeWriter=new QRCodeWriter();
//        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
//        Path path = FileSystems.getDefault().getPath(filePath);
//        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
//    }
//
//    public static void main(String[] args) {
//        try {
//            generateQRCodeImage("hello world",350,350, "D:/java/mall/prepare/static/qrtest.png");
//        } catch (WriterException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
