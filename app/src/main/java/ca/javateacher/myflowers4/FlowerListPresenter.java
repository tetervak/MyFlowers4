package ca.javateacher.myflowers4;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ca.javateacher.myflowers4.viewmodel.FlowerListViewModel;

public class FlowerListPresenter {

  private static final String TAG = "FlowerListPresenter";

  private final FlowerListFragment mFragment;
  private final FlowerRecyclerViewAdapter mAdapter;

  public FlowerListPresenter(@NonNull FlowerListFragment fragment,
                             @NonNull RecyclerView recyclerView){
    Log.d(TAG, "FlowerListPresenter() called");
    mFragment = fragment;
    mAdapter = new FlowerRecyclerViewAdapter();
    recyclerView.setAdapter(mAdapter);

  }

  public void setViewModel(@NonNull FlowerListViewModel viewModel){
    Log.d(TAG, "setViewModel() called");
    viewModel.getFlowerListData().observe(mFragment, mAdapter::setFlowerList);
  }
}
