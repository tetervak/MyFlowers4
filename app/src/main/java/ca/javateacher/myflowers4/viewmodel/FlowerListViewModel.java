package ca.javateacher.myflowers4.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import javax.inject.Inject;

import ca.javateacher.myflowers4.di.FlowerApplication;
import ca.javateacher.myflowers4.domain.FlowerListInteractions;
import ca.javateacher.myflowers4.domain.FlowerListItemDto;

public class FlowerListViewModel extends AndroidViewModel {

  private static final String TAG = "FlowerListViewModel";

  @Inject
  public FlowerListInteractions mInter;

  public FlowerListViewModel(@NonNull Application application) {
    super(application);
    Log.d(TAG, "FlowerListViewModel() called");
    ((FlowerApplication)application).getApplicationComponent().inject(this);
  }

  public void loadFileData(){
    mInter.loadFileData();
  }

  public void clearAllData(){
    mInter.clearAllData();
  }

  @NonNull
  public LiveData<List<FlowerListItemDto>> getFlowerListData() {
    return mInter.getFlowerListData();
  }

}
