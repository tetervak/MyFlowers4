package ca.javateacher.myflowers4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AboutFragment extends DialogFragment {

  private static final String TAG = "AboutFragment";

  public AboutFragment() {
    // Required empty public constructor
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    Log.d(TAG, "onCreateDialog() called");
    // create a new AlertDialog Builder
    AlertDialog.Builder builder =
        new AlertDialog.Builder(getActivity());

    builder.setTitle(R.string.app_name);
    builder.setMessage(R.string.author);

    builder.setPositiveButton(android.R.string.ok, null);

    return builder.create();
  }
}
