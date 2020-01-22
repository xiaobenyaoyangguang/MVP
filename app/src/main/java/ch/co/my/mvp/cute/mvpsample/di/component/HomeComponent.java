package ch.co.my.mvp.cute.mvpsample.di.component;

import dagger.Component;
import ch.co.my.mvp.cute.mvpsample.ui.activity.MainActivity;
import ch.co.my.mvp.cute.mvpsample.di.module.HomeModule;
import ch.co.my.mvp.cute.mvpsample.di.scope.FragmentScope;

@FragmentScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(MainActivity activity);

}
