package ca.javateacher.myflowers4;

import android.util.Log;

import androidx.annotation.NonNull;

import ca.javateacher.myflowers4.databinding.FragmentFlowerDetailsBinding;
import ca.javateacher.myflowers4.viewmodel.FlowerDetailsViewModel;

public class FlowerDetailsPresenter {

  private static final String TAG = "FlowerDetailsPresenter";

  private FlowerDetailsFragment mFragment;
  private FragmentFlowerDetailsBinding mBinding;

  public FlowerDetailsPresenter(@NonNull FlowerDetailsFragment fragment,
                                @NonNull FragmentFlowerDetailsBinding binding) {
    Log.d(TAG, "FlowerDetailsPresenter() called");
    mFragment = fragment;
    mBinding = binding;
  }

  public void setViewModel(@NonNull FlowerDetailsViewModel viewModel) {
    Log.d(TAG, "setViewModel() called");
    viewModel
        .getFlowerDetails().observe(mFragment,flower -> mBinding.setFlower(flower));
  }
}
