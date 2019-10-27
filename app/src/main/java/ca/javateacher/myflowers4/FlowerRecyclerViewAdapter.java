package ca.javateacher.myflowers4;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static ca.javateacher.myflowers4.Constants.*;
import ca.javateacher.myflowers4.databinding.FlowerListItemBinding;
import ca.javateacher.myflowers4.domain.FlowerListItemDto;

public class FlowerRecyclerViewAdapter
        extends RecyclerView.Adapter<FlowerRecyclerViewAdapter.ViewHolder> {

    private List<FlowerListItemDto> mFlowerList;

    public FlowerRecyclerViewAdapter() {
    }

    public void setFlowerList(List<FlowerListItemDto> flowerList) {
        mFlowerList = flowerList;
        notifyDataSetChanged();
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FlowerListItemBinding binding
                = FlowerListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        FlowerListItemDto flower = mFlowerList.get(position);
        holder.mFlower = flower;
        holder.mBinding.setFlower(flower);

        holder.mBinding.getRoot().setOnClickListener(v -> showDetails(v, flower.getId()));
    }

    private void showDetails(View v, int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(FLOWER_ID_KEY, id);
        Navigation.findNavController(v).navigate(R.id.action_list_to_details, bundle);
    }

    @Override
    public int getItemCount() {
        if (mFlowerList != null) {
            return mFlowerList.size();
        }else{
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final FlowerListItemBinding mBinding;
        public FlowerListItemDto mFlower;

        public ViewHolder(FlowerListItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        @Override
        @NonNull
        public String toString() {
            return super.toString() + " '"
                    + mBinding.flowerLabel.getText() + "'";
        }
    }
}