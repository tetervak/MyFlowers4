package ca.javateacher.myflowers4.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import ca.javateacher.myflowers4.viewmodel.FlowerDetailsViewModel;
import ca.javateacher.myflowers4.viewmodel.FlowerListViewModel;
import dagger.BindsInstance;
import dagger.Component;


// Definition of the Application  Dagger graph
@Singleton
@Component(modules = {FlowerDatabaseModule.class, FlowerRepositoryModule.class})
public interface ApplicationComponent {

  // Factory to create instances of the ApplicationComponent
  @Component.Factory
  interface Factory {
    ApplicationComponent create(@BindsInstance Context context);
  }

  void inject(FlowerListViewModel flowerListViewModel);
  void inject(FlowerDetailsViewModel flowerDetailsViewModel);
}
