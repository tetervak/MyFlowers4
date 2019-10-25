package ca.javateacher.myflowers4.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FlowerDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long insertFlower(FlowerEntity flower);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insertFlowers(List<FlowerEntity> flowerEntityList);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insertFlowers(FlowerEntity ... flowerEntity);

  @Query("DELETE FROM flowers")
  void deleteAllFlowers();

  @Query("DELETE FROM flowers WHERE id = :id")
  void deleteFlowerById(int id);

  @Delete
  void deleteFlower(FlowerEntity flowerEntity);

  @Query("SELECT * from flowers ORDER BY label ASC")
  LiveData<List<FlowerEntity>> getFlowerListData();

  @Update
  void updateFlowers(FlowerEntity ... flowerEntities);

  @Update
  void updateFlower(FlowerEntity flowerEntity);

  @Update
  void updateFlowers(List<FlowerEntity> flowerEntitiyList);

  @Query("SELECT * from flowers WHERE id = :id")
  LiveData<FlowerEntity> getFlowerDataById(int id);

  @Query("SELECT * from flowers WHERE id = :id")
  FlowerEntity getFlowerById(int id);
}
