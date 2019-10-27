package ca.javateacher.myflowers4;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import ca.javateacher.myflowers4.viewmodel.FlowerListViewModel;

public class FlowerListFragment extends Fragment {

  private FlowerListViewModel mViewModel;
  private FlowerListPresenter mPresenter;

  public FlowerListFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      // notify that the fragment has own menu
      setHasOptionsMenu(true);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_flower_list, container, false);

    RecyclerView recyclerView = view.findViewById(R.id.flower_list);
    Context context = view.getContext();
    recyclerView.setLayoutManager(new LinearLayoutManager(context));

    mPresenter = new FlowerListPresenter(this, recyclerView);

    return view;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    mViewModel = ViewModelProviders.of(this)
        .get(FlowerListViewModel.class);
    mPresenter.setViewModel(mViewModel);
  }

  @Override
  public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.menu_list, menu);
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    switch(item.getItemId()) {
      case R.id.load_data_file:{
        mViewModel.loadFileData();
        return true;
      }
      case R.id.clear_all_data:{
        mViewModel.clearAllData();
        return true;
      }
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
