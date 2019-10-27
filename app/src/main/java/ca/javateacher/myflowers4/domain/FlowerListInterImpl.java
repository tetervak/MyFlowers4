package ca.javateacher.myflowers4.domain;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ca.javateacher.myflowers4.repository.FlowerRepository;

// represents flower list interactions
public class FlowerListInterImpl implements FlowerListInter {

  private FlowerRepository mFlowerRepository;

  @Inject
  public FlowerListInterImpl(FlowerRepository flowerRepository) {
    mFlowerRepository = flowerRepository;
  }

  @Override
  public void loadFileData(){
    mFlowerRepository.loadFileData();
  }

  @Override
  public void clearAllData(){
    mFlowerRepository.clearAllData();
  }

  @Override
  @NonNull
  public LiveData<List<FlowerListItemDto>> getFlowerListData() {
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
        new FlowerListItemDto(
            (int)flower.getId(),
            flower.getLabel(),
            image);
  }

}
