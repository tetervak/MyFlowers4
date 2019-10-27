package ca.javateacher.myflowers4.domain;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import javax.inject.Inject;

import ca.javateacher.myflowers4.repository.FlowerRepository;

// represents flower details interactions
public class FlowerDetailsInterImpl implements FlowerDetailsInteractions {

  private FlowerRepository mFlowerRepository;
  private MutableLiveData<Integer> mFlowerIdData;
  private LiveData<FlowerDetailsDto> mFlowerDetailsData;

  @Inject
  public FlowerDetailsInterImpl(FlowerRepository flowerRepository) {
    mFlowerRepository = flowerRepository;
    mFlowerIdData = new MutableLiveData<>();
    mFlowerDetailsData = Transformations.switchMap(mFlowerIdData,this::getFlowerDetailsById);
  }

  @Override
  public void setFlowerId(int id){
    mFlowerIdData.setValue(id);
  }

  @Override
  @NonNull
  public LiveData<FlowerDetailsDto> getFlowerDetails(){
    return mFlowerDetailsData;
  }

  @NonNull
  private LiveData<FlowerDetailsDto> getFlowerDetailsById(int id){
    return
        Transformations.map(mFlowerRepository.getFlowerDataById(id),
            this::flower2Details);
  }

  @Override
  public void deleteFlower(){
    Integer flowerId = mFlowerIdData.getValue();
    if(flowerId != null){
      deleteFlowerById(flowerId);
    }
  }

  private void deleteFlowerById(int id){
    mFlowerRepository.deleteFlowerById(id);
  }

  @NonNull
  private FlowerDetailsDto flower2Details(@NonNull Flower flower){
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
