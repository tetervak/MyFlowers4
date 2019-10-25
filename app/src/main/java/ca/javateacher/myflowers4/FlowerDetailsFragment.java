package ca.javateacher.myflowers4;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
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

  private int mFlowerId;
  private FragmentFlowerDetailsBinding mBinding;
  private FlowerDetailsViewModel mFlowerDetailsViewModel;

  public FlowerDetailsFragment() {
        // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // notify that the fragment has own menu
    setHasOptionsMenu(true);
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    mBinding = FragmentFlowerDetailsBinding.inflate(getLayoutInflater());
    // lookup the index from the arguments
    assert getArguments() != null;
    mFlowerId = getArguments().getInt(FLOWER_ID_KEY);
    return mBinding.getRoot();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    assert getActivity() != null;
    mFlowerDetailsViewModel = ViewModelProviders.of(this)
      .get(FlowerDetailsViewModel.class);
    mFlowerDetailsViewModel.getFlowerDetailsById(mFlowerId).observe(this,
      flower -> {
        if(flower != null){
          mBinding.setFlower(flower);
        }
      });
  }

  @Override
  public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.menu_details, menu);
  }

  @SuppressWarnings({"SwitchStatementWithTooFewBranches", "ConstantConditions"})
  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    switch(item.getItemId()) {
      case R.id.delete_flower:{
        mFlowerDetailsViewModel.deleteFlowerById(mFlowerId);
        Navigation.findNavController(getView()).navigate(R.id.action_global_list);
        return true;
      }
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}

