package com.liumapp.pattern.sign;

import com.liumapp.pattern.encode.EncodingBack;
import com.liumapp.pattern.exception.PatternPropertiesNumberNotEnough;
import com.liumapp.pattern.exception.WrongType;
import com.liumapp.pattern.keystore.KeyStorePattern;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liumapp on 11/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class PdfPattern implements EncodingBack {

    private String type = "signPdf";

    private String certFile;

    private BigDecimal leftTopX;

    private BigDecimal leftTopY;

    private BigDecimal width;

    private BigDecimal height;

    private String signImagePath;

    public static PdfPattern parse(String line) throws PatternPropertiesNumberNotEnough, WrongType {
        PdfPattern pdfPattern = new PdfPattern();
        String[] items = line.split("[\\s_]+");

        List<String> tmp = Arrays.asList(items);
        LinkedList<String> lists = new LinkedList<String>(tmp);

        if (lists.size() < 11) {
            throw new PatternPropertiesNumberNotEnough();
        }

        if (!lists.pop().equals(pdfPattern.getType())) {
            throw new WrongType();
        }

        return pdfPattern;
    }

    public void setImportant(String certFile, BigDecimal leftTopX, BigDecimal leftTopY, BigDecimal width, BigDecimal height, String signImagePath) {
        this.certFile = certFile;
        this.leftTopX = leftTopX;
        this.leftTopY = leftTopY;
        this.width = width;
        this.height = height;
        this.signImagePath = signImagePath;
    }

    @Override
    public String getEncoding() {
        LinkedList<String> lists = new LinkedList<String>();
        String result = "";

        lists.add(type);
        lists.add(certFile);
        lists.add(leftTopX.setScale(2 , BigDecimal.ROUND_HALF_UP).toString());
        lists.add(leftTopY.setScale(2 , BigDecimal.ROUND_HALF_UP).toString());
        lists.add(width.setScale(2 , BigDecimal.ROUND_HALF_UP).toString());
        lists.add(height.setScale(2 , BigDecimal.ROUND_HALF_UP).toString());
        lists.add(signImagePath);

        while (lists.size() > 1) {
            result += lists.pop() + "_";
        }

        result += lists.pop();
        return result;
    }

    @Override
    public boolean chk() {
        return !(this.certFile == null ||
                this.leftTopX == null ||
                this.leftTopY == null ||
                this.width == null ||
                this.height == null ||
                this.signImagePath == null);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCertFile() {
        return certFile;
    }

    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    public BigDecimal getLeftTopX() {
        return leftTopX;
    }

    public void setLeftTopX(BigDecimal leftTopX) {
        this.leftTopX = leftTopX;
    }

    public BigDecimal getLeftTopY() {
        return leftTopY;
    }

    public void setLeftTopY(BigDecimal leftTopY) {
        this.leftTopY = leftTopY;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getSignImagePath() {
        return signImagePath;
    }

    public void setSignImagePath(String signImagePath) {
        this.signImagePath = signImagePath;
    }
}
