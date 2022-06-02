package com.example.lovecalculator42;

import android.app.Application;

import com.example.lovecalculator42.network.LovApi;
import com.example.lovecalculator42.network.RetrofitService;

public class App extends Application {

   public static LovApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitService retrofitService = new RetrofitService();
        api = retrofitService.getLoveApi();
    }
}
