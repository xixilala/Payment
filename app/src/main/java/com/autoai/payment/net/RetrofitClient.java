package com.autoai.payment.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nxp on 2020-05-17.
 */
public class RetrofitClient {

    private static volatile RetrofitClient instance;
    private APIService mAPIService;
    private String baseUrl = "http://www.wanandroid.com";

    private RetrofitClient() {
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                    instance = new RetrofitClient();
                }
            }
        }
        return instance;
    }

    /**
     * 设置Header
     *
     * @return
     */
    private Interceptor getHeaderInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        //添加token
                        .header("token", "");
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
    }

    //设置拦截器
    private Interceptor getInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //显示日志
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    public APIService getApi() {
        //初始化一个client,不然retrofit会默认添加一个
        OkHttpClient client = new OkHttpClient().newBuilder()
                //设置Header
                .addInterceptor(getHeaderInterceptor())
                //设置拦截器
                .addInterceptor(getInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                //设置网络请求的url地址
                .baseUrl(baseUrl)
                //设置数据解析器
                .addConverterFactory(GsonConverterFactory.create())
                //设置网络请求适配器,使其支持RxJava与RxAndroid
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        //创建 网络请求接口 实例
        mAPIService = retrofit.create(APIService.class);
        return mAPIService;
    }
}