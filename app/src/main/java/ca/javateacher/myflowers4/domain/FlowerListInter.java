package ca.javateacher.myflowers4.domain;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

public interface FlowerListInter {

  void loadFileData();
  void clearAllData();

  @NonNull
  LiveData<List<FlowerListItemDto>> getFlowerListData();
}
