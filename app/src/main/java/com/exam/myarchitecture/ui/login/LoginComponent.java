package com.exam.myarchitecture.ui.login;

import com.exam.myarchitecture.ApplicationComponent;
import com.exam.myarchitecture.injector.PerActivity;

import dagger.Component;

/**
 * Created by fan on 2016/8/10.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
