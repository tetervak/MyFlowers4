package ca.javateacher.myflowers4;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ca.javateacher.myflowers4.viewmodel.FlowerListViewModel;

public class FlowerListPresenter {

  private FlowerListFragment mFragment;
  private final FlowerRecyclerViewAdapter mAdapter;

  public FlowerListPresenter(@NonNull FlowerListFragment fragment,
                             @NonNull RecyclerView recyclerView){

    mFragment = fragment;
    mAdapter = new FlowerRecyclerViewAdapter();
    recyclerView.setAdapter(mAdapter);

  }

  public void setViewModel(@NonNull FlowerListViewModel viewModel){
    viewModel.getFlowerListData().observe(mFragment, mAdapter::setFlowerList);
  }
}
