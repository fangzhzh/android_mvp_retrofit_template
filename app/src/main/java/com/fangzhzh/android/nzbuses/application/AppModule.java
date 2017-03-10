package com.fangzhzh.android.nzbuses.application;

import android.app.Application;
import android.content.res.Resources;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import java.io.IOException;
import javax.inject.Singleton;

import com.fangzhzh.android.nzbuses.api.MainAPIService;
import com.fangzhzh.android.nzbuses.utils.CONST;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author zhangzhenfang
 * @since 1/18/17 4:33 AM
 */
@Module
public class AppModule {
    private Application application;
    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return  application;
    }

    @Provides
    @Singleton
    public Resources provideResources() {
        return application.getResources();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        OkHttpClient okClient = new OkHttpClient.Builder()
            .addNetworkInterceptor(new StethoInterceptor())
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    HttpUrl url = request.url().newBuilder().addQueryParameter("key",CONST.API_KEY).build();
                    request = request.newBuilder().url(url).build();
                    return chain.proceed(request);
                }
            })
            .build();
        return new Retrofit.Builder()
                .baseUrl(CONST.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okClient)
                .build();
    }
    @Provides
    @Singleton
    public MainAPIService provideWeatherAPIService() {
        return provideRetrofit().create(MainAPIService.class);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new Gson();
    }

}
