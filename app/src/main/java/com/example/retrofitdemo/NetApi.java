package com.example.retrofitdemo;


import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetApi {
    @GET("%E7%A6%8F%E5%88%A9/100/1")
    Observable<HttpResult<List<ResponseBean>>> getMyBase();

    @POST("country/list")
    Observable<ResponseBody> getBase();
}
