package com.annasblackhat.daggerprovidesnetworking.dependency;

import com.annasblackhat.daggerprovidesnetworking.network.GithubService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ANNASBlackHat on 04/03/2017.
 */

@Module(includes = NetworkModule.class)
public class GitModule {

    @Provides @GitScope
    GithubService githubService(Retrofit retrofit){
        return retrofit.create(GithubService.class);
    }

    @Provides @GitScope
    Retrofit retrofit(OkHttpClient client, Gson gson){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .baseUrl("https://api.github.com")
                .build();
    }

    @Provides @GitScope
    Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        return gsonBuilder.create();
    }
}
