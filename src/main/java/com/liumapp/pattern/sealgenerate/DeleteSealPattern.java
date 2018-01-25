package com.liumapp.pattern.sealgenerate;

import com.liumapp.pattern.encode.EncodingBack;
import com.liumapp.pattern.exception.PatternPropertiesNumberNotEnough;
import com.liumapp.pattern.exception.WrongType;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DeleteSealPattern implements EncodingBack {

    private String type = "deleteseal";

    private String path;

    public static DeleteSealPattern parse(String line) throws PatternPropertiesNumberNotEnough, WrongType {
        DeleteSealPattern deleteSealPattern = new DeleteSealPattern();
        String[] items = line.split("[\\s_]+");

        List<String> tmp = Arrays.asList(items);
        LinkedList<String> lists = new LinkedList<String>(tmp);

        if (lists.size() < 2) {
            throw new PatternPropertiesNumberNotEnough();
        }

        if (!lists.pop().equals(deleteSealPattern.getType())) {
            throw new WrongType();
        }
        deleteSealPattern.setPath(lists.pop());
        return deleteSealPattern;
    }

    @Override
    public String getEncoding() {
        LinkedList<String> lists = new LinkedList<>();
        String result = "";

        lists.add(type);
        lists.add(path);

        while(lists.size() > 1) {
            result += lists.pop() + "_";
        }

        result += lists.pop();
        return result;
    }

    @Override
    public boolean chk() {
        return !(this.type == null || this.path == null);
    }

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setImportant(String path) {
        this.path = path;
    }
}
