package com.ascii.framework.base;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

// @SpringBootApplication
// @ImportResource("classpath:com/ascii/framework/base/kie/rule.xml")
public class Main {

    public static void main(String[] args) {
        // SpringApplication.run(Main.class, args);

        Pattern p = Pattern.compile("^[\\d]{6}[ /|/ ]*+[\\d]*+");
        // System.out.println(p.matcher("123456 / 123456 / 123456 / 123456234234").matches());
        System.out.println(p.matcher("123456").matches());
        System.out.println(p.matcher("123456 ").matches());
        System.out.println(p.matcher("123456 /").matches());
        System.out.println(p.matcher("123456/").matches());
        System.out.println(p.matcher("123456/123456").matches());
        System.out.println(p.matcher("123456/ 123456").matches());
        System.out.println(p.matcher("123456 /123456").matches());
        System.out.println(p.matcher("123456 / 123456234234").matches());
        String term = "12-3142-0162623-00";
        String number = term.replaceAll("[-/ ]", StringUtils.EMPTY);
        // number = number.replaceAll("[/ ]", StringUtils.EMPTY);
        System.out.println(number);
    }

}
