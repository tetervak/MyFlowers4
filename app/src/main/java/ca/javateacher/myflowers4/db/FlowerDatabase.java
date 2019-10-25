package ca.javateacher.myflowers4.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {FlowerEntity.class}, version = 1, exportSchema = false)
public abstract class FlowerDatabase extends RoomDatabase {

  public abstract FlowerDao getFlowerDao();
}
