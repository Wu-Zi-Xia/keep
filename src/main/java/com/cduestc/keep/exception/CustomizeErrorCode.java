package com.cduestc.keep.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    POST_NOT_FOUND("你的动态不在了，要不然换个试试呗",2001),
    TARGET_PARENT_NOT_FOUND("未选中任何动态或者评论回复",2002),
     NO_LOGIN("当前账户未登录，请登录重试",2003),
     TYPE_PARAM_WRONG ("您未选中任何元素，请选择一个吧",2004),
    PARENT_COMMENT_NOT_FOUND("你操作的评论不存在了",2005),
    PARENT_POST_NOT_FOUND("你操作的动态不存在了",2006 ),
    SYSTEM_ERROR("服务器冒烟了，请稍后重试",2007),
    COMMENT_IS_EMPTY("评论内容不能为空",2008 ),
    READ_NOTIFICATION_FAIL("兄弟你这是读别人的信息呢？",2009 ),
    NOTIFICATION_NOT_FOUND("你的通知不在了，要不然换个试试呗",2010),
    FILE_UPLOAD_FAIL("图片上传失败！！",2011),
    PRODUCT_NOT_FOUND("商品不存在，换个试试呗！！",2012),
    PRODUCT_IS_ENPTY("已经到底了,再刷我就冒烟了！！",2013),
    PRODUCT_CATEGORY_NOT_FOUND("商品类别不存在,换个试试呗！！",2014),
    SEARCH_IS_ENPTY("手抖了一下吗?搜索内容不能为空哦！",2015),
    PRODUCT_CATEGORY_IS_ENPTY("商品类不能为空！！",2016),
    PRODUCT_CATEGORY_IS_NOT_EXIST("商品类不能为空！！",2016),
    NOT_HAVE_POSTS("你还没有发布动态哦！",2017),
    PARAM_IS_WRONG("参数非法！",2018),
    NICK_NAME_IS_HAVE("昵称已经存在！！！",2019),
    RESOURCE_IS_NULL("资源不能为空！！",2020),
    RESOURCE_IS_FULL("不能同时上传图片和视频！！",2021),
    SPORTS_DATA_IS_NOT_FOUND("还没有运动数据，快去运动起来吧！！",2022),
    RESOURCE_NOT_FOUND("资源没有找到！！",2023);
    private String message;
    private Integer code;
    @Override
    public String getMessage()
    {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(String s, Integer c){
        this.message=s;
        this.code=c;
    }
}
