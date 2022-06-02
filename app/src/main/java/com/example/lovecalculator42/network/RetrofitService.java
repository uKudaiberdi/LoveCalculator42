package com.example.lovecalculator42.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    Retrofit api = new Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public LovApi getLoveApi() {
        return api.create(LovApi.class);
    }

}
