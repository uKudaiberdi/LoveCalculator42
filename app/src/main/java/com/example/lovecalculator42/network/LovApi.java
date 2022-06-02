package com.example.lovecalculator42.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface LovApi {

    @GET("getPercentage")
    Call<LoveModel> loveCalculate(@Query("fname") String firstname,
                                  @Query("sname") String secondFame,
                                  @Header("X-RapidAPI-Host") String host,
                                  @Header("X-RapidAPI-Key") String key);
}
