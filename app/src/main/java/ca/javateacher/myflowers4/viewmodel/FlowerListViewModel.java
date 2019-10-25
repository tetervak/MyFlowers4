package ca.javateacher.myflowers4.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ca.javateacher.myflowers4.di.FlowerApplication;
import ca.javateacher.myflowers4.model.Flower;
import ca.javateacher.myflowers4.repository.FlowerRepository;
import ca.javateacher.myflowers4.dto.FlowerListItemDto;

public class FlowerListViewModel extends AndroidViewModel {

  private static final String TAG = "FlowerListViewModel";

  @Inject
  public FlowerRepository mFlowerRepository;

  public FlowerListViewModel(@NonNull Application application) {
    super(application);
    Log.d(TAG, "FlowerListViewModel() called");
    ((FlowerApplication)application).getApplicationComponent().inject(this);
  }

  public void loadFileData(){
    mFlowerRepository.loadFileData();
  }

  public void clearAllData(){
    mFlowerRepository.clearAllData();
  }

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
