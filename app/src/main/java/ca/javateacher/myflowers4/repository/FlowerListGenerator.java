package ca.javateacher.myflowers4.repository;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import ca.javateacher.myflowers4.R;
import ca.javateacher.myflowers4.model.Flower;

// used for debugging only
@Singleton
public class FlowerListGenerator extends FlowerInitRepository {

  @Inject
  public FlowerListGenerator(Context context){
    super(context);
  }

  private static final String TAG = "FlowerListGenerator";

  // used for debugging only
  @Override
  @NonNull
  public List<Flower> getFlowerListSync(){
    Log.d(TAG, "getFlowerListSync() called");
    Resources resources = getApplicationContext().getResources();
    String[] names = resources.getStringArray(R.array.flower_names);
    String[] labels = resources.getStringArray(R.array.flower_labels);

    ArrayList<Flower> list = new ArrayList<>();
    String description = resources.getString(R.string.description);
    String uri = resources.getString(R.string.wikipedia_aster_url);
    for (int i = 0; i < labels.length; i++) {
      list.add(new FlowerImpl(names[i], labels[i], description, uri));
    }
    return list;
  }

}
