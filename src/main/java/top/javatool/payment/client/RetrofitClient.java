package top.javatool.payment.client;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import top.javatool.payment.converter.FastJsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yang Peng on 2017/5/10.
 *
 */
public class RetrofitClient {


    private String baseUrl;


    public RetrofitClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Retrofit getRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        return  new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
    }



}
