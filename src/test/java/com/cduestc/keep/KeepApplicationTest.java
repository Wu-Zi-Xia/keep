package com.cduestc.keep;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

class KeepApplicationTest {
//@Test
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
}