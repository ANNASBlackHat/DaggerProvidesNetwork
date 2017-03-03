package com.annasblackhat.daggerprovidesnetworking.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.annasblackhat.daggerprovidesnetworking.R;
import com.annasblackhat.daggerprovidesnetworking.dependency.ContextModule;
import com.annasblackhat.daggerprovidesnetworking.dependency.DaggerGitComponent;
import com.annasblackhat.daggerprovidesnetworking.dependency.GitComponent;
import com.annasblackhat.daggerprovidesnetworking.model.Repository;
import com.annasblackhat.daggerprovidesnetworking.network.GithubService;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Inject
    Picasso picasso;

    @Inject
    GithubService githubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitComponent component = DaggerGitComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        component.injectMainActivity(this);

        githubService.getRepositories().enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if(response.isSuccessful()){
                    List<Repository> repositories = response.body();
                    for(Repository repo : repositories){
                        Log.d(TAG, "onResponse: "+repo.getName());
                    }
                }else{

                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {

            }
        });
    }
}
