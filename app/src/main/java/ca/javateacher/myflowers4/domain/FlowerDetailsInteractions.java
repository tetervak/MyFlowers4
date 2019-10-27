package ca.javateacher.myflowers4.domain;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public interface FlowerDetailsInteractions {

  void setFlowerId(int id);

  @NonNull
  LiveData<FlowerDetailsDto> getFlowerDetails();

  void deleteFlower();
}
