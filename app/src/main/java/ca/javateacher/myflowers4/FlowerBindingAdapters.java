package ca.javateacher.myflowers4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.util.Linkify;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

public class FlowerBindingAdapters {

  @BindingAdapter("imageFromAsset")
  public static void bindImageFromAsset(ImageView imageView, String filePath){
    if (filePath != null) {
      // have to check against null!
      Context context = imageView.getContext();
      try (InputStream stream = context.getAssets().open(filePath)) {
        Drawable drawable = Drawable.createFromStream(stream, null);
        imageView.setImageDrawable(drawable);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @BindingAdapter("wikiLink")
  public static void insertWikiLink(TextView textView, String link){
    if (link != null) {
      // have to check against null!
      Context context = textView.getContext();
      textView.setText(R.string.learn_more_at_wikipedia);
      String wikipedia = context.getString(R.string.wikipedia);
      Pattern pattern = Pattern.compile(wikipedia);
      Linkify.addLinks(textView, pattern, link, null, (match, url) -> "");
    }
  }
}
