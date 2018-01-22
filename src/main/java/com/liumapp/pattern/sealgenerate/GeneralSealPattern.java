package com.liumapp.pattern.sealgenerate;

import com.liumapp.pattern.encode.EncodingBack;
import com.liumapp.pattern.exception.PatternPropertiesNumberNotEnough;
import com.liumapp.pattern.exception.WrongType;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GeneralSealPattern implements EncodingBack {

    private String type = "generalSeal";
    /**
     * 要生成的企业名称
     */
    private String companyName;

    public void setImportant(String companyName) {
        this.companyName = companyName;
    }

    public static GeneralSealPattern parse(String line) throws PatternPropertiesNumberNotEnough, WrongType {
        GeneralSealPattern generalSealPattern = new GeneralSealPattern();
        String[] items = line.split("[\\s_]+");

        List<String> tmp = Arrays.asList(items);
        LinkedList<String> lists = new LinkedList<String>(tmp);

        if (lists.size() < 2) {
            throw new PatternPropertiesNumberNotEnough();
        }

        if (!lists.pop().equals(generalSealPattern.getType())) {
            throw new WrongType();
        }
        generalSealPattern.setCompanyName(lists.pop());
        return generalSealPattern;
    }

    @Override
    public String getEncoding() {
        LinkedList<String> lists = new LinkedList<>();
        String result = "";

        lists.add(type);
        lists.add(companyName);

        while(lists.size() > 1) {
            result += lists.pop() + "_";
        }

        result += lists.pop();
        return result;
    }

    @Override
    public boolean chk() {
        return !(this.type == null || this.companyName == null);
    }

    public String getType() {
        return type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
