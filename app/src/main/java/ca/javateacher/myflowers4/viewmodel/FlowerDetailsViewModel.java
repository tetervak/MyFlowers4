package ca.javateacher.myflowers4.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import javax.inject.Inject;

import ca.javateacher.myflowers4.di.FlowerApplication;
import ca.javateacher.myflowers4.domain.FlowerDetailsInteractions;
import ca.javateacher.myflowers4.domain.FlowerDetailsDto;

public class FlowerDetailsViewModel extends AndroidViewModel {

  private static final String TAG = "FlowerDetailsViewModel";

  @Inject
  public FlowerDetailsInteractions mInter;

  public FlowerDetailsViewModel(@NonNull Application application) {
    super(application);
    Log.d(TAG, "FlowerDetailsViewModel() called");
    ((FlowerApplication)application).getApplicationComponent().inject(this);
  }

  public void setFlowerId(int id){
    Log.d(TAG, "setFlowerId() called with: id = [" + id + "]");
    mInter.setFlowerId(id);
  }

  @NonNull
  public LiveData<FlowerDetailsDto> getFlowerDetails(){
    Log.d(TAG, "getFlowerDetails() called");
    return mInter.getFlowerDetails();
  }

  public void deleteFlower(){
    Log.d(TAG, "deleteFlower() called");
    mInter.deleteFlower();
  }

}
