package com.jia.retrofitdemo.net;

import com.jia.retrofitdemo.bean.Comment;
import com.jia.retrofitdemo.bean.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Describtion: 网络请求api类
 * Created by jia on 2017/3/10 0010.
 * 人之所以能，是相信能
 */
public interface Api {

    // 登录
    @GET("index.php")
    // 截止到？之前
    Call<Login> getLogin(@Query("r") String r, @Query("device_type") String device_type, @Query("mobile") String mobile, @Query("password") String password);


    // 提交评论
    /* 使用POST 请求方式时，只需要更改方法定义的标签，用@POST 标签，
       参数标签用 @Field 或者@Body或者FieldMap，注意：使用POST 方式
       时注意2点，1，必须加上 @FormUrlEncoded标签，否则会抛异常。
       2，使用POST方式时，必须要有参数，否则会抛异常 */
    @FormUrlEncoded
    @POST("index.php")
    Call<Comment> postComment(@Field("r") String r, @Field("device_type") String device_type, @Field("user_id") String user_id, @Field("content") String content);
}
