package ca.javateacher.myflowers4.di;

import android.app.Application;

// appComponent lives in the Application class to share its lifecycle
public class FlowerApplication extends Application {

  // Reference to the application graph that is used across the whole app
  ApplicationComponent mApplicationComponent = DaggerApplicationComponent.factory().create(this);

  public ApplicationComponent getApplicationComponent(){
    return mApplicationComponent;
  }
}
