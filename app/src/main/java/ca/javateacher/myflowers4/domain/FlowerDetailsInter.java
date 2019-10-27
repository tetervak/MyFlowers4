package ca.javateacher.myflowers4.domain;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public interface FlowerDetailsInter {
  void setFlowerId(int id);

  @NonNull
  LiveData<FlowerDetailsDto> getFlowerDetails();

  void deleteFlowerById(int id);
}
