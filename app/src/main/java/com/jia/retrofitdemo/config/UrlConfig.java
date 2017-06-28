package com.jia.retrofitdemo.config;

/**
 * Describtion: url配置类
 * Created by jia on 2017/3/10 0010.
 * 人之所以能，是相信能
 */
public class UrlConfig {

    // baseUrl必须以 / 结尾
    public static final String baseUrl = "http://api.lovek12.com/v190/";

    // http://api.lovek12.com/v190/index.php?r=site/login&device_type=ad1&mobile=18210836561&password=123456
    public static final String loginUrl = baseUrl + "";

    // http://api.lovek12.com/v190/index.php?r=resource/comment
    public static final String commentUrl=baseUrl+"";

}
