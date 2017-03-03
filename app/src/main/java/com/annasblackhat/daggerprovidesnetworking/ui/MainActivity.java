package com.annasblackhat.daggerprovidesnetworking.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.annasblackhat.daggerprovidesnetworking.R;
import com.annasblackhat.daggerprovidesnetworking.dependency.ContextModule;
import com.annasblackhat.daggerprovidesnetworking.dependency.DaggerGitComponent;
import com.annasblackhat.daggerprovidesnetworking.dependency.GitComponent;
import com.annasblackhat.daggerprovidesnetworking.network.GithubService;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

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

        System.out.println("Picasso IS NULL : "+String.valueOf(picasso == null));
        System.out.println("Service IS NULL : "+String.valueOf(githubService == null));
    }
}
