package com.liumapp.pattern.certificate;

import com.liumapp.pattern.exception.PatternPropertiesNumberNotEnough;
import com.liumapp.pattern.exception.WrongType;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liumapp on 11/24/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class ExporterPattern {

    private String type = "exportCert";

    private String keyStore;

    private String keyStorePd;

    private String alias;

    private String certPd;

    private String savePath;

    private String fileName;

    /**
     * exportCert_keystore_kestorepassword_alias_certPd_savepath_filename
     * @param line String
     * @return ExporterPattern
     * @throws PatternPropertiesNumberNotEnough
     * @throws WrongType
     */
    public static ExporterPattern parse (String line) throws PatternPropertiesNumberNotEnough, WrongType {
        ExporterPattern exporterPattern = new ExporterPattern();
        String[] items = line.split("[\\s_]+");

        List<String> tmp = Arrays.asList(items);
        LinkedList<String> lists = new LinkedList<String>(tmp);

        if (lists.size() < 7) {
            throw new PatternPropertiesNumberNotEnough();
        }

        if (!lists.pop().equals(exporterPattern.getType())) {
            throw new WrongType();
        }

        exporterPattern.setKeyStore(lists.pop());
        exporterPattern.setKeyStorePd(lists.pop());
        exporterPattern.setAlias(lists.pop());
        exporterPattern.setCertPd(lists.pop());
        exporterPattern.setSavePath(lists.pop());
        exporterPattern.setFileName(lists.pop());

        return exporterPattern;
    }

    public String getType() {
        return type;
    }

    public String getKeyStore() {
        return keyStore;
    }

    public void setKeyStore(String keyStore) {
        this.keyStore = keyStore;
    }

    public String getKeyStorePd() {
        return keyStorePd;
    }

    public void setKeyStorePd(String keyStorePd) {
        this.keyStorePd = keyStorePd;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCertPd() {
        return certPd;
    }

    public void setCertPd(String certPd) {
        this.certPd = certPd;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
