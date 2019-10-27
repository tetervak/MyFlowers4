package ca.javateacher.myflowers4.domain;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ca.javateacher.myflowers4.repository.FlowerRepository;

// represents flower list interactions
public class FlowerListInterImpl implements FlowerListInteractions {

  private static final String TAG="FlowerListInterImpl";

  private FlowerRepository mFlowerRepository;

  @Inject
  public FlowerListInterImpl(FlowerRepository flowerRepository) {
    Log.d(TAG, "FlowerListInterImpl() called");
    mFlowerRepository = flowerRepository;
  }

  @Override
  public void loadSampleData(){
    Log.d(TAG, "loadSampleData() called");
    mFlowerRepository.loadSampleData();
  }

  @Override
  public void clearAllData(){
    Log.d(TAG, "clearAllData() called");
    mFlowerRepository.clearAllData();
  }

  @Override
  @NonNull
  public LiveData<List<FlowerListItemDto>> getFlowerListData() {
    Log.d(TAG, "getFlowerListData() called");
    return
        Transformations.map(mFlowerRepository.getFlowerListData(),
            this::flowerEntities2Items);
  }

  @NonNull
  private List<FlowerListItemDto> flowerEntities2Items(@NonNull List<Flower> list){
    List<FlowerListItemDto> items =  new ArrayList<>();
    for(Flower flower : list){
      items.add(flower2ListItem(flower));
    }
    return items;
  }

  @NonNull
  private FlowerListItemDto flower2ListItem(@NonNull Flower flower){
    String image = "images/flowers/" + flower.getName() + "_small.jpeg";
    return
      new FlowerListItemDtoImpl(
          (int)flower.getId(),
          flower.getLabel(),
          image);
  }

}
