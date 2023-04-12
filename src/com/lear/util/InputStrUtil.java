package com.lear.util;

import java.util.Locale;

/**
 * 输入字符串处理工具类
 * @author 天狗
 */
public class InputStrUtil {

    private static final String TRUE = "t";
    private static final String TURE_FULL = "true";
    private static final String FALSE = "f";
    private static final String FALSE_FULL = "false";

    public static boolean isTrue(String str) {
        str = str.toLowerCase(Locale.ROOT).replaceAll(" ", "");
        return TRUE.equals(str) || TURE_FULL.equals(str);
    }

    public static String getPromptText() {
        return String.format("请输入指令：(%s/%s)", TRUE, FALSE);
    }

    public static String getContinuePromptText() {
        return "Enter anything to continue...";
    }


}
