package com.annasblackhat.daggerprovidesnetworking.network;

import com.annasblackhat.daggerprovidesnetworking.model.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ANNASBlackHat on 04/03/2017.
 */

public interface GithubService {
    @GET("/users/annasblackhat/repos")
    Call<List<Repository>> getRepositories();
}
