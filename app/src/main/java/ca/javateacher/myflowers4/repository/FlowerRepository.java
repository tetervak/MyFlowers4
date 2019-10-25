package ca.javateacher.myflowers4.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import java.util.List;

import ca.javateacher.myflowers4.model.Flower;

public interface FlowerRepository {
  void loadFileData();
  void clearAllData();

  @NonNull
  LiveData<List<Flower>> getFlowerListData();

  @NonNull
  LiveData<Flower> getFlowerDataById(int id);
  void deleteFlowerById(int id);
}
