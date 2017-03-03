package com.annasblackhat.daggerprovidesnetworking.dependency;

import android.content.Context;
import android.util.Log;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by ANNASBlackHat on 04/03/2017.
 */

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides @GitScope
    OkHttpClient okHttpClient(HttpLoggingInterceptor interceptor, Cache cache){
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
    }

    @Provides @GitScope
    HttpLoggingInterceptor httpLoggingInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("HTTP LOGGING ", message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides @GitScope
    Cache cache(File fileCache){
        return new Cache(fileCache, 10 * 1000 * 1000); //10 MB;
    }

    @Provides @GitScope
    File file(Context context){
        File fileCache = new File(context.getCacheDir(), "okhttp_cache");
        fileCache.mkdir();
        return fileCache;
    }
}
