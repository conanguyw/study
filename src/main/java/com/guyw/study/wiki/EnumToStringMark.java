package com.guyw.study.wiki;

import org.apache.commons.lang3.StringUtils;

/**
 * @author conangu
 * @createTime 2019-07-02 14:54
 * @description 枚举值转wiki描述
 */
public class EnumToStringMark {
    static String s = "/** 国内机票 */\n" +
            "                                           TICKET(\"TICKET\", \"国内机票\"),\n" +
            "                                           /** 国际机票 */\n" +
            "                                           TICKETINT(\"TICKETINT\", \"国际机票\"),\n" +
            "                                           /** 国内机票APP */\n" +
            "                                           TICKETAPP(\"TICKETAPP\", \"国内机票APP\"),\n" +
            "                                           /** 国际机票APP */\n" +
            "                                           TICKETINTAPP(\"TICKETINTAPP\", \"国际机票APP\"),\n" +
            "                                           /** 火车 */\n" +
            "                                           TRAIN(\"TRAIN\", \"火车\"),\n" +
            "                                           /** 外部券码 */\n" +
            "                                           COUPON(\"COUPON\", \"外部券码\"),\n" +
            "                                           /** 实物商品 */\n" +
            "                                           ENTITY(\"ENTITY\", \"实物商品\"),\n" +
            "                                           /** 辅营实物 */\n" +
            "                                           ANCILLARYENTITY(\"ANCILLARYENTITY\", \"辅营实物\"),\n" +
            "                                           /** 超链接商品 */\n" +
            "                                           URL(\"URL\", \"超链接商品\"),\n" +
            "                                           /** 机场服务券 */\n" +
            "                                           AIRPORT(\"AIRPORT\", \"机场服务券\"),\n" +
            "                                           /** 艺龙国内机票APP */\n" +
            "                                           ICKETYLAPP(\"TICKETYLAPP\", \"艺龙国内机票APP\"),\n" +
            "                                           /** 艺龙国际机票APP */\n" +
            "                                           TICKETINTYLAPP(\"TICKETINTYLAPP\", \"艺龙国际机票APP\"),\n" +
            "                                           /** 国际酒店\u2028APP */\n" +
            "                                           HOTELINTAPP(\"HOTELINTAPP\", \"国际酒店\u2028APP\"),\n" +
            "                                           /** 其它 */\n" +
            "                                           OTHER(\"OTHER\", \"其它\"),\n" +
            "                                           /** 景区和用车 */\n" +
            "                                           WECHATCARD(\"WECHATCARD\", \"景区和用车\"),\n" +
            "                                           /** 国内酒店(微信公共卡券) */\n" +
            "                                           WECHATCOUPONELHOTAL(\"WECHATCOUPONELHOTAL\", \"国内酒店(微信公共卡券)\"),\n" +
            "                                           /** 国际酒店(微信公共卡券) */\n" +
            "                                           WECHATCOUPONELHOTALINT(\"WECHATCOUPONELHOTALINT\", \"国际酒店(微信公共卡券)\"),\n" +
            "                                           /** 汽车票(微信公共卡券) */\n" +
            "                                           WECHATCOUPONBUS(\"WECHATCOUPONBUS\", \"汽车票(微信公共卡券)\"),\n" +
            "                                           /** 船票(微信公共卡券) */\n" +
            "                                           WECHATCOUPONBOAT(\"WECHATCOUPONBOAT\", \"船票(微信公共卡券)\"),";


    public static void main(String args[]) {
        String lins[] =s.split("\n");

        for (int i = 0; i < lins.length; i++) {
            String temp = lins[i].trim();
            if (StringUtils.isBlank(temp)){
                continue;
            }
            if (!temp.contains("(") || !temp.contains(")")){
                continue;
            }
            temp = temp.substring(temp.indexOf("(")+1,temp.lastIndexOf(")")).replaceAll(" ","");
            temp = temp.replace(",",":")+",";


            System.out.print(temp);

        }



    }

    }
