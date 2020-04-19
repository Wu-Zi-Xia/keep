package com.cduestc.keep.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class OnlineShopService {
    public Object search(String search){
        if(StringUtils.isNotBlank(search))
        {
            String[] tags= StringUtils.split(search," ");
            search= Arrays.stream(tags).collect(Collectors.joining("|"));
        }
        return null;
    }
}
