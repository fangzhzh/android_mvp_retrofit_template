package com.fangzhzh.android.nzbuses.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author zhangzf
 * @since Mar 8, 2017 10:41 AM
 */
public interface MainAPIService {


    //TODO: api calls, Object should be java pojo class
    @GET("data") Call<Object> getData(@Query(value = "q") String city);

}
