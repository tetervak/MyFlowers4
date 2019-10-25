package ca.javateacher.myflowers4.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import javax.inject.Inject;

import ca.javateacher.myflowers4.di.FlowerApplication;
import ca.javateacher.myflowers4.model.Flower;
import ca.javateacher.myflowers4.repository.FlowerRepository;
import ca.javateacher.myflowers4.dto.FlowerDetailsDto;

public class FlowerDetailsViewModel extends AndroidViewModel {

  private static final String TAG = "FlowerDetailsViewModel";

  @Inject
  public FlowerRepository mFlowerRepository;

  private MutableLiveData<Integer> mFlowerIdData;
  private LiveData<FlowerDetailsDto> mFlowerDetailsData;

  public FlowerDetailsViewModel(@NonNull Application application) {
    super(application);
    Log.d(TAG, "FlowerDetailsViewModel() called");
    ((FlowerApplication)application).getApplicationComponent().inject(this);

    mFlowerIdData = new MutableLiveData<>();
    mFlowerDetailsData = Transformations.switchMap(mFlowerIdData,this::getFlowerDetailsById);
  }

  public void setFlowerId(int id){
    mFlowerIdData.setValue(id);
  }

  @NonNull
  public LiveData<FlowerDetailsDto> getFlowerDetails(){
    return mFlowerDetailsData;
  }

  @NonNull
  public LiveData<FlowerDetailsDto> getFlowerDetailsById(int id){
    return
        Transformations.map(mFlowerRepository.getFlowerDataById(id),
            this::flower2Details);
  }

  public void deleteFlowerById(int id){
    mFlowerRepository.deleteFlowerById(id);
  }

  @NonNull
  private FlowerDetailsDto flower2Details(@NonNull Flower flower){
    String image = "images/flowers/" + flower.getName() + "_large.jpeg";
    return
        new FlowerDetailsDto(
            (int)flower.getId(),
            flower.getLabel(),
            flower.getDescription(),
            flower.getUri(),
            image);
  }

}
