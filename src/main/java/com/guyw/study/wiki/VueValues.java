package com.guyw.study.wiki;

import org.apache.commons.lang3.StringUtils;

/**
 * @author conangu
 * @createTime 2019-05-29 17:57
 * @description wiki转Java实体
 */
public class VueValues {

    static String k = "#name: [\n" +
            "                    {required: true, message: '请输入#message', trigger: 'blur'},\n" +
            "                ],";

    static String s =
                    "/**\n" +
                    " * 模板活动编号 db_column: fgac_code \n" +
                    " */\n" +
                    " fgacCode;\n" +
                    "/**\n" +
                    " * 活动名称 db_column: fgac_name \n" +
                    " */\n" +
                    " fgacName;\n" +
                    "/**\n" +
                    " * 活动状态 db_column: fgac_status \n" +
                    " */\n" +
                    " fgacStatus;\n" +
                    "/**\n" +
                    " * 活动开始时间 db_column: fgac_start_time \n" +
                    " */\n" +
                    " fgacStartTime;\n" +
                    "/**\n" +
                    " * 活动结束时间 db_column: fgac_end_time \n" +
                    " */\n" +
                    " fgacEndTime;\n" +
                    "/**\n" +
                    " * 参团首次获得的奖品db_column: fgac_first_promotion_code \n" +
                    " */\n" +
                    " fgacFirstPromotionCode;\n" +
                    "/**\n" +
                    " * 参团首次获得的奖品展示名称db_column: fgac_first_promotion_name \n" +
                    " */\n" +
                    " fgacFirstPromotionName;\n" +
                    "/**\n" +
                    " * 参团获得的奖品db_column: fgac_normal_promotion_code \n" +
                    " */\n" +
                    " fgacNormalPromotionCode;\n" +
                    "/**\n" +
                    " * 参团获得的奖品展示名称db_column: fgac_normal_promotion_name \n" +
                    " */\n" +
                    " fgacNormalPromotionName;\n" +
                    "/**\n" +
                    " * 入口图片 db_column: fgac_entrance_img \n" +
                    " */\n" +
                    " fgacEntranceImg;\n" +
                    "/**\n" +
                    " * 按钮图片 db_column: fgac_button_img \n" +
                    " */\n" +
                    " fgacButtonImg;\n" +
                    "/**\n" +
                    " * 背景色db_column: fgac_back_ground_color \n" +
                    " */\n" +
                    " fgacBackGroundColor;\n" +
                    "/**\n" +
                    " * 规则图片 db_column: fgac_rule_img \n" +
                    " */\n" +
                    " fgacRuleImg;";


    public static void main(String args[]){

        String lins[] =s.split("\n");

        for (int i = 0; i < lins.length/4; i++) {

            String temp1 = lins[4*i+1].trim().split("db")[0].trim().substring(1).trim();
            String temp2 = lins[4*i+3].trim().split(";")[0].trim();


            String a = k.replace("#name",temp2).replace("#message",temp1);
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
