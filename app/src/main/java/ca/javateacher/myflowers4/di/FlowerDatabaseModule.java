package ca.javateacher.myflowers4.di;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import javax.inject.Singleton;

import ca.javateacher.myflowers4.db.FlowerDao;
import ca.javateacher.myflowers4.db.FlowerDatabase;
import dagger.Module;
import dagger.Provides;

@Module
public class FlowerDatabaseModule {

  private static final String TAG = "FlowerDatabaseModule";

  @Singleton
  @Provides
  public FlowerDatabase getFlowerDatabase(Context context){
    Log.d(TAG, "getFlowerDatabase() called");
    return Room.databaseBuilder(context.getApplicationContext(),
        FlowerDatabase.class, "flower_database")
        // Wipes and rebuilds instead of migrating if no Migration object.
        .fallbackToDestructiveMigration()
        //.addCallback(sRoomDatabaseCallback)
        .build();
  }

  @Singleton
  @Provides
  public FlowerDao getFlowerDao(FlowerDatabase flowerDatabase){
    Log.d(TAG, "getFlowerDao() called");
    return flowerDatabase.getFlowerDao();
  }
}
