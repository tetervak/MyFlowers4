package ca.javateacher.myflowers4.repository;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.List;
import javax.inject.Singleton;

import ca.javateacher.myflowers4.domain.Flower;

@Singleton
public abstract class FlowerInitRepository {

  private static final String TAG = "FlowerInitRepository";

  private Context mAppContext;

  public FlowerInitRepository(@NonNull Context context){
    Log.d(TAG, "FlowerInitRepository() called");
    mAppContext = context.getApplicationContext();
  }

  @NonNull
  public abstract List<Flower> getFlowerListSync();

  @NonNull
  public Context getApplicationContext() {
    return mAppContext;
  }
}
