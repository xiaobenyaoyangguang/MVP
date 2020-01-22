package jp.co.ricoh.advop.cute.mvpsample.di.component;

import dagger.Component;
import jp.co.ricoh.advop.cute.mvpsample.ui.activity.MainActivity;
import jp.co.ricoh.advop.cute.mvpsample.di.module.HomeModule;
import jp.co.ricoh.advop.cute.mvpsample.di.scope.FragmentScope;

@FragmentScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(MainActivity activity);

}
