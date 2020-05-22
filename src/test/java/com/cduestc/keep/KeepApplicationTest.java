package com.cduestc.keep;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

class KeepApplicationTest {
@Test
    protected void test(){
    String a = "https://wuzixia-1300212146.cos.ap-chengdu.myqcloud.com/keep/avatarURL/37.png";
    String[] arr = a.split("/");
    int len=0;
    for(int i=0;i<3;i++){
        len+=arr[i].length();
        System.out.println(arr[i]);
    }
    len+=3;
    System.out.println(len);
    System.out.println(a.substring(len));

}
    //@Test
    protected void test1(){
    String str1=",A12,C12,B13,A11,C11,B12,A11,C13,B11,A12,C13,B12,A13,C12,B12";
        String substring = str1.substring(1);
        System.out.println(substring);
    }
}