package ca.javateacher.myflowers4;

import android.content.Context;

import javax.inject.Singleton;

import ca.javateacher.myflowers4.di.FlowerDatabaseModule;
import ca.javateacher.myflowers4.di.FlowerRepositoryModule;
import ca.javateacher.myflowers4.repository.FlowerFileReader;
import ca.javateacher.myflowers4.repository.FlowerListGenerator;
import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {FlowerDatabaseModule.class, FlowerRepositoryModule.class})
public interface TestComponent {

  // Factory to create instances of the ApplicationComponent
  @Component.Factory
  interface Factory {
    TestComponent create(@BindsInstance Context context);
  }

  FlowerListGenerator getFlowerListGenerator();
  FlowerFileReader getFlowerFileReader();
}
