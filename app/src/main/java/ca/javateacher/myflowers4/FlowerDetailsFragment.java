package ca.javateacher.myflowers4;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import static ca.javateacher.myflowers4.Constants.*;
import ca.javateacher.myflowers4.databinding.FragmentFlowerDetailsBinding;
import ca.javateacher.myflowers4.viewmodel.FlowerDetailsViewModel;

public class FlowerDetailsFragment extends Fragment {

  private static final String TAG = "FlowerDetailsFragment";

  private int mFlowerId;
  private FlowerDetailsPresenter mPresenter;
  private FlowerDetailsViewModel mViewModel;

  public FlowerDetailsFragment() {
        // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, "onCreate() called");
    // notify that the fragment has own menu
    setHasOptionsMenu(true);
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    Log.d(TAG, "onCreateView() called");
    // Inflate the layout for this fragment
    FragmentFlowerDetailsBinding binding
        = FragmentFlowerDetailsBinding.inflate(getLayoutInflater());
    // lookup the index from the arguments
    assert getArguments() != null;
    mFlowerId = getArguments().getInt(FLOWER_ID_KEY);
    mPresenter = new FlowerDetailsPresenter(this, binding);
    return binding.getRoot();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    Log.d(TAG, "onActivityCreated() called");
    assert getActivity() != null;
    mViewModel = ViewModelProviders.of(this)
      .get(FlowerDetailsViewModel.class);
    // set the query data
    mViewModel.setFlowerId(mFlowerId);
    // the presenter observes the query result
    mPresenter.setViewModel(mViewModel);
  }

  @Override
  public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    Log.d(TAG, "onCreateOptionsMenu() called");
    inflater.inflate(R.menu.menu_details, menu);
  }

  @SuppressWarnings({"SwitchStatementWithTooFewBranches", "ConstantConditions"})
  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    Log.d(TAG, "onOptionsItemSelected() called");
    switch(item.getItemId()) {
      case R.id.delete_flower:{
        Log.d(TAG, "onOptionsItemSelected(): delete flower");
        mViewModel.deleteFlower();
        Navigation.findNavController(getView()).navigate(R.id.action_global_list);
        return true;
      }
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}

