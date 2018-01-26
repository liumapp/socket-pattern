package com.liumapp.pattern.sendemail;


import com.liumapp.pattern.encode.EncodingBack;
import com.liumapp.pattern.exception.PatternPropertiesNumberNotEnough;
import com.liumapp.pattern.exception.WrongType;

import java.util.*;

public class SendEmailPattern implements EncodingBack {

    private String type = "send-email";

    private Integer code;              //标记

    private List<String> emails;      //邮箱

    private Object content;           //发送的内容

    private String subject;           //邮件的主题

    @Override
    public String getEncoding() {
        LinkedList<Object> lists = new LinkedList<>();
        String result = "";

        lists.add(type);
        lists.add(code);
        lists.add(emails);
        lists.add(subject);
        lists.add(content);
        while (lists.size() > 1) {
            result += lists.pop() + "_";
        }
        result += lists.pop();
        return result;
    }

    @Override
    public boolean chk() {
        return !(
                code == null ||
                        emails == null ||
                        content == null ||
                        subject == null
        );
    }
    public void sendEmailPattern(Integer code, List<String> emails, Object content, String subject) {
        this.code = code;
        this.emails = emails;
        this.content = content;
        this.subject = subject;
    }

    public static SendEmailPattern parse(String line) throws PatternPropertiesNumberNotEnough, WrongType {
        SendEmailPattern sendEmailPattern = new SendEmailPattern();
        String[] items = line.split("[\\s_]+");
        List<String> tmp = Arrays.asList(items);
        LinkedList<String> lists = new LinkedList<String>(tmp);
        if (lists.size() < 4) {
            throw new PatternPropertiesNumberNotEnough();
        }
        if (!lists.pop().equals(sendEmailPattern.getType())) {
            throw new WrongType();
        }
        sendEmailPattern.setCode(Integer.parseInt(lists.pop()));
        List<String> result = Arrays.asList(lists.pop().split(","));
        sendEmailPattern.setEmails(result);
        sendEmailPattern.setSubject(lists.pop());
        sendEmailPattern.setContent(lists.pop());

        return sendEmailPattern;
    }

    public String getType() {
        return type;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
