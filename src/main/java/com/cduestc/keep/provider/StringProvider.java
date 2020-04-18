package com.cduestc.keep.provider;

public class StringProvider {
    public static String getRandomString(long length) {
        System.out.println("正在生成文本");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            long result = 0;
            result = Math.round(Math.random() * 25 + 97);
            sb.append(String.valueOf((char) result));
        }
        System.out.println("成功生成");
        return sb.toString();
    } // 随机生成字符串
}
