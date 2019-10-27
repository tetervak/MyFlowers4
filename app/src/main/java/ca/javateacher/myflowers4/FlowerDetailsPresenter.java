package ca.javateacher.myflowers4;

import androidx.annotation.NonNull;

import ca.javateacher.myflowers4.databinding.FragmentFlowerDetailsBinding;
import ca.javateacher.myflowers4.viewmodel.FlowerDetailsViewModel;

public class FlowerDetailsPresenter {

  private FlowerDetailsFragment mFragment;
  private FragmentFlowerDetailsBinding mBinding;

  public FlowerDetailsPresenter(@NonNull FlowerDetailsFragment fragment,
                                @NonNull FragmentFlowerDetailsBinding binding) {
    mFragment = fragment;
    mBinding = binding;
  }

  public void setViewModel(@NonNull FlowerDetailsViewModel viewModel) {
    viewModel
        .getFlowerDetails().observe(mFragment,flower -> mBinding.setFlower(flower));
  }
}
