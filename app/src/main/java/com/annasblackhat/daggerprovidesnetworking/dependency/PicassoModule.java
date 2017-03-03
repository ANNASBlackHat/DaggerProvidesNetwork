package com.annasblackhat.daggerprovidesnetworking.dependency;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by ANNASBlackHat on 04/03/2017.
 */

@Module(includes = {ContextModule.class, NetworkModule.class})
public class PicassoModule {

    @Provides
    @GitScope
    Picasso picasso(Context context, OkHttp3Downloader  okHttp3Downloader){
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides @GitScope
    OkHttp3Downloader okHttp3Downloader(OkHttpClient client){
        return new OkHttp3Downloader(client);
    }
}
