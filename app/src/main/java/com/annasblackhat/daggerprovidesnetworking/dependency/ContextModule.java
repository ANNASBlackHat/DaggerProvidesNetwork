package com.annasblackhat.daggerprovidesnetworking.dependency;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ANNASBlackHat on 04/03/2017.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides @GitScope
    public Context context(){
        return context;
    }
}
