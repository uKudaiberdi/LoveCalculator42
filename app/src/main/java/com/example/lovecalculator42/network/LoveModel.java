package com.example.lovecalculator42.network;

//
//    "fname": "CatWoman",
//            "sname": "Batman",
//            "percentage": "53",
//            "result": "All the best!"

import com.google.gson.annotations.SerializedName;

public class LoveModel {

    @SerializedName("fname")
    public String firstName;
    @SerializedName("sname")
    public String secondName;
    public String percentage;
    public String result;

}
