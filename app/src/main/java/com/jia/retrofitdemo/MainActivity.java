package com.jia.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jia.retrofitdemo.bean.Comment;
import com.jia.retrofitdemo.bean.Login;
import com.jia.retrofitdemo.config.UrlConfig;
import com.jia.retrofitdemo.net.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 创建Retrofit对象
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(UrlConfig.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) // 添加gson解析，叫做转换器。当然也支持其他解析方式，但gson是主流
                .build();

        // 使用动态拦截技术，获取接口实例
        Api api=retrofit.create(Api.class);




        // 调用实例方法创建call
        Call<Login> call=api.getLogin("site/login","ad1","18210836561","123456");
        // 进行一步网络请求   同步请求：Response<Login> response = call.execute();
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                // response.body()为返回的实体类
                Login mLogin=response.body();

                Toast.makeText(MainActivity.this,"登录成功"+mLogin.getData(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_LONG).show();
            }
        });




        Call<Comment> call2=api.postComment("feed-back/index","ad1","74","很棒很棒很棒");
        call2.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                Comment mComment=response.body();
                if(mComment.getStatus().equals("1")){
                    Toast.makeText(MainActivity.this,"提交成功",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,response.body().getNote(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                Toast.makeText(MainActivity.this,"提交失败",Toast.LENGTH_LONG).show();
            }
        });
    }
}
