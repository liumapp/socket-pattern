package com.liumapp.pattern.keystore;

import com.liumapp.pattern.SocketPattern;
import com.liumapp.pattern.certificate.PersonalPattern;
import com.liumapp.pattern.exception.PatternPropertiesNumberNotEnough;
import com.liumapp.pattern.exception.WrongType;
import com.liumapp.pattern.security.GeneratorPdn;

/**
 * Created by liumapp on 11/21/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class KeyStorePattern extends SocketPattern implements GeneratorPdn {

    private String type = "keyStore";

    private String savePath;

    private String keyStoreName;

    private String generatorPd;

    private String keyStorePd;

    private Integer keyLength;

    /**
     * fc: first cert
     *
     * 个人证书：个人姓名
     *
     * 企业证书：企业名称
     *
     * 在生成keystore的时候，需要初始化第一个证书
     */
    private String fcName;

    private String fcProvince;

    private String fcCity;

    private String fcCountry;

    /**
     * 建议与证书名称保持一致
     */
    private String fcAlias;

    private String fcPassword;

    public String getType() {
        return type;
    }

    /**
     * keyStore_generatorPd_liumapp.ks_keyStorePd_2048_/usr/local/data/keystore_country_province_city_alias_certPd
     * @param line order line
     */
    public static KeyStorePattern parse(String line) throws PatternPropertiesNumberNotEnough , WrongType {
        KeyStorePattern keyStorePattern = new KeyStorePattern();
        String[] items = line.split("[\\s_]]+");

        if (items.length < 6) {
            throw new PatternPropertiesNumberNotEnough();
        }

        if (!items[0].equals(keyStorePattern.getType())) {
            throw new WrongType();
        }

        keyStorePattern.setGeneratorPd(items[1]);
        keyStorePattern.setKeyStoreName(items[2]);
        keyStorePattern.setKeyStorePd(items[3]);
        keyStorePattern.setKeyLength(Integer.getInteger(items[4]));
        keyStorePattern.setSavePath(items[5]);
        keyStorePattern.setFcCountry(items[6]);
        keyStorePattern.setFcProvince(items[7]);
        keyStorePattern.setFcCity(items[8]);
        keyStorePattern.setFcAlias(items[9]);
        keyStorePattern.setFcPassword(items[10]);

        return keyStorePattern;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getKeyStoreName() {
        return keyStoreName;
    }

    public void setKeyStoreName(String keyStoreName) {
        this.keyStoreName = keyStoreName;
    }

    public String getKeyStorePd() {
        return keyStorePd;
    }

    public void setKeyStorePd(String keyStorePd) {
        this.keyStorePd = keyStorePd;
    }

    public Integer getKeyLength() {
        return keyLength;
    }

    public void setKeyLength(Integer keyLength) {
        this.keyLength = keyLength;
    }

    public String getFcName() {
        return fcName;
    }

    public void setFcName(String fcName) {
        this.fcName = fcName;
    }

    public String getFcProvince() {
        return fcProvince;
    }

    public void setFcProvince(String fcProvince) {
        this.fcProvince = fcProvince;
    }

    public String getFcCity() {
        return fcCity;
    }

    public void setFcCity(String fcCity) {
        this.fcCity = fcCity;
    }

    public String getFcCountry() {
        return fcCountry;
    }

    public void setFcCountry(String fcCountry) {
        this.fcCountry = fcCountry;
    }

    public String getFcAlias() {
        return fcAlias;
    }

    public void setFcAlias(String fcAlias) {
        this.fcAlias = fcAlias;
    }

    public String getFcPassword() {
        return fcPassword;
    }

    public void setFcPassword(String fcPassword) {
        this.fcPassword = fcPassword;
    }

    @Override
    public String getGeneratorPd() {
        return generatorPd;
    }

    @Override
    public void setGeneratorPd(String generatorPd) {
        this.generatorPd = generatorPd;
    }
}
