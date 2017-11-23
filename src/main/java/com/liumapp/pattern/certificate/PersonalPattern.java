package com.liumapp.pattern.certificate;

import com.liumapp.pattern.exception.PatternPropertiesNumberNotEnough;
import com.liumapp.pattern.exception.WrongType;

import java.util.*;

/**
 * Created by liumapp on 11/20/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class PersonalPattern {

    private String type = "personalCert";

    /**
     * 别名
     */
    private String alias;

    /**
     * 个人证书密码
     */
    private String certPassword;

    /**
     * 密钥库名称
     */
    private String keystore;

    /**
     * 密钥库密码
     */
    private String storepass;

    /**
     * 加密算法
     */
    private String keyalg = "RSA";

    /**
     * 证书有效期天数
     */
    private Integer validity = 365;

    /**
     * 身份证号码
     */
    private String identityCode;

    /**
     * 密钥长度
     */
    private Integer keysize = 2048;

    /**
     * 私钥密码
     */
    private String keypass;

    /**
     * 完整的名字
     */
    private String name;

    /**
     * 密钥对拥有者名字
     */
    private String firstname;

    /**
     * 密钥对拥有者姓字
     */
    private String lastname;

    /**
     * 组织或者单位名称
     */
    private String organization;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区域
     */
    private String area;

    /**
     * 国家代码
     * 例如：中国，就填写CN
     */
    private String country;

    /**
     * 性别
     */
    private String sex;

    /**
     * type_keystoreName_keystorePd_alias_certPd_name_identityCode_sex_country_province_city
     * @param line
     */
    public static PersonalPattern parse(String line) throws PatternPropertiesNumberNotEnough, WrongType {
        PersonalPattern personalPattern = new PersonalPattern();
        String[] items = line.split("[\\s_]+");

        List<String> tmp = Arrays.asList(items);
        LinkedList<String> lists = new LinkedList<String>(tmp);

        if (lists.size() < 11) {
            throw new PatternPropertiesNumberNotEnough();
        }

        if (!lists.pop().equals(personalPattern.getType())) {
            throw new WrongType();
        }

        personalPattern.setKeystore(lists.pop());
        personalPattern.setStorepass(lists.pop());
        personalPattern.setAlias(lists.pop());
        personalPattern.setCertPassword(lists.pop());
        personalPattern.setName(lists.pop());
        personalPattern.setIdentityCode(lists.pop());
        personalPattern.setSex(lists.pop());
        personalPattern.setCountry(lists.pop());
        personalPattern.setProvince(lists.pop());
        personalPattern.setCity(lists.pop());

        return personalPattern;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getKeystore() {
        return keystore;
    }

    public void setKeystore(String keystore) {
        this.keystore = keystore;
    }

    public String getStorepass() {
        return storepass;
    }

    public void setStorepass(String storepass) {
        this.storepass = storepass;
    }

    public String getKeyalg() {
        return keyalg;
    }

    public void setKeyalg(String keyalg) {
        this.keyalg = keyalg;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public Integer getKeysize() {
        return keysize;
    }

    public void setKeysize(Integer keysize) {
        this.keysize = keysize;
    }

    public String getKeypass() {
        return keypass;
    }

    public void setKeypass(String keypass) {
        this.keypass = keypass;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
