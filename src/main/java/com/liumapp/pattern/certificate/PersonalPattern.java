package com.liumapp.pattern.certificate;

/**
 * Created by liumapp on 11/20/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class PersonalPattern {

    /**
     * 别名
     */
    private String alias;

    private String savepath;

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
     * name_identityCode_sex_country_province_city
     * @param line
     */
    public static PersonalPattern parse(String line) {
        PersonalPattern personalPattern = new PersonalPattern();
        String[] items = line.split("[\\s_]+");

        if (items.length < 4) {
            return null;
        }

        personalPattern.setName(items[0]);
        personalPattern.setIdentityCode(items[1]);
        personalPattern.setSex(items[2]);
        personalPattern.setCountry(items[3]);
        personalPattern.setProvince(items[4]);
        personalPattern.setCity(items[5]);
        return personalPattern;
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

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
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
