package ca.javateacher.myflowers4.repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.List;
import javax.inject.Singleton;

import ca.javateacher.myflowers4.model.Flower;

@Singleton
public abstract class FlowerInitRepository {

  private static final String TAG = "FlowerInitRepository";

  private Context mAppContext;

  public FlowerInitRepository(@NonNull Application application){
    Log.d(TAG, "FlowerInitRepository() called");
    mAppContext = application;
  }

  @NonNull
  public abstract List<Flower> getFlowerListSync();

  @NonNull
  public Context getApplicationContext() {
    return mAppContext;
  }
}
