package com.annasblackhat.daggerprovidesnetworking.dependency;

import com.annasblackhat.daggerprovidesnetworking.ui.MainActivity;

import dagger.Component;

/**
 * Created by ANNASBlackHat on 04/03/2017.
 */

@GitScope
@Component(modules = {GitModule.class, PicassoModule.class})
public interface GitComponent {

    void injectMainActivity(MainActivity mainActivity);

}
