package com.guyw.study.wiki;

import org.apache.commons.lang3.StringUtils;

/**
 * @author conangu
 * @createTime 2019-05-29 17:57
 * @description wiki转Java实体
 */
public class WikiToBean {

    static String k = "    /**\n" +
            "     *@ms\n" +
            "     */\n" +
            "    private @pa @mt;";

    static String s = "PhoneNumber\tstring\t手机号码\n" +
            "ValidateCode\tstring\t手机验证码";




    public static void main(String args[]){

        String lins[] =s.split("\n");

        for (int i = 0; i < lins.length; i++) {
            String temp = lins[i].trim();
            if (StringUtils.isBlank(temp)){
                continue;
            }
            String ks[] =temp.split("\t");
            String k1 = toLowerCaseFirstOne(ks[0]);
            String k2 = !ks[1].startsWith("int")?toUpperCaseFirstOne(ks[1]):ks[1];
            String k3 = ks[2];

            String a = k.replace("@ms",k3).replace("@pa",k2).replace("@mt",k1);
            System.out.println(a);

            System.out.println("");
        }



    }
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    //首字母转大写
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
