package ca.javateacher.myflowers4.domain;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import javax.inject.Inject;

import ca.javateacher.myflowers4.repository.FlowerRepository;

// represents flower details interactions
public class FlowerDetailsInterImpl implements FlowerDetailsInteractions {

  private static final String TAG = "FlowerDetailsInterImpl";

  private FlowerRepository mFlowerRepository;
  private MutableLiveData<Integer> mFlowerIdData;
  private LiveData<FlowerDetailsDto> mFlowerDetailsData;

  @Inject
  public FlowerDetailsInterImpl(FlowerRepository flowerRepository) {
    Log.d(TAG, "FlowerDetailsInterImpl() called");
    mFlowerRepository = flowerRepository;
    mFlowerIdData = new MutableLiveData<>();
    mFlowerDetailsData = Transformations.switchMap(mFlowerIdData,this::getFlowerDetailsById);
  }

  @Override
  public void setFlowerId(int id){
    Log.d(TAG, "setFlowerId() called with: id = [" + id + "]");
    mFlowerIdData.setValue(id);
  }

  @Override
  @NonNull
  public LiveData<FlowerDetailsDto> getFlowerDetails(){
    Log.d(TAG, "getFlowerDetails() called");
    return mFlowerDetailsData;
  }

  @NonNull
  private LiveData<FlowerDetailsDto> getFlowerDetailsById(int id){
    Log.d(TAG, "getFlowerDetailsById() called with: id = [" + id + "]");
    return
        Transformations.map(mFlowerRepository.getFlowerDataById(id),
            this::flower2Details);
  }

  @Override
  public void deleteFlower(){
    Log.d(TAG, "deleteFlower() called");
    Integer flowerId = mFlowerIdData.getValue();
    if(flowerId != null){
      deleteFlowerById(flowerId);
    }
  }

  private void deleteFlowerById(int id){
    Log.d(TAG, "deleteFlowerById() called with: id = [" + id + "]");
    mFlowerRepository.deleteFlowerById(id);
  }

  @NonNull
  private FlowerDetailsDto flower2Details(@NonNull Flower flower){
    Log.d(TAG, "flower2Details() called");
    String image = "images/flowers/" + flower.getName() + "_large.jpeg";
    return
        new FlowerDetailsDtoImpl(
            (int)flower.getId(),
            flower.getLabel(),
            flower.getDescription(),
            flower.getUri(),
            image);
  }

}
