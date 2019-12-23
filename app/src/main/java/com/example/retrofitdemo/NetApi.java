package com.example.retrofitdemo;


import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NetApi {
    @GET("%E7%A6%8F%E5%88%A9/{count}/1")
    Observable<HttpResult<List<ResponseBean>>> getMyBase(@Path("count") int count);

    @POST("country/list")
    Observable<ResponseBody> getBase();
}
