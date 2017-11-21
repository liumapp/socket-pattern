package com.liumapp.pattern.keystore;

import com.liumapp.pattern.certificate.PersonalPattern;
import com.liumapp.pattern.exception.PatternPropertiesNumberNotEnough;
import com.liumapp.pattern.security.GeneratorPdn;

/**
 * Created by liumapp on 11/21/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class KeyStorePattern extends GeneratorPdn {

    private String name;

    private String keyStorePd;

    private Integer keyLength;

    /**
     *
     * @param line
     */
    public static PersonalPattern parse(String line) throws PatternPropertiesNumberNotEnough {
        PersonalPattern personalPattern = new PersonalPattern();
        String[] items = line.split("[\\s_]+");

        if (items.length < 6) {
            throw new PatternPropertiesNumberNotEnough("properties number lt 6");
        }

        personalPattern.setName(items[0]);
        personalPattern.setIdentityCode(items[1]);
        personalPattern.setSex(items[2]);
        personalPattern.setCountry(items[3]);
        personalPattern.setProvince(items[4]);
        personalPattern.setCity(items[5]);
        return personalPattern;

    }

}
