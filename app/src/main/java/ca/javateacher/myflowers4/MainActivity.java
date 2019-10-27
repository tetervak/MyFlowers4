package ca.javateacher.myflowers4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Log.d(TAG, "onCreate() called");
      setContentView(R.layout.activity_main);

      // make the toolbar "up" button work with the navigation
      Toolbar toolbar = findViewById(R.id.toolbar);
      NavController navController
              = Navigation.findNavController(this, R.id.nav_host_fragment);
      AppBarConfiguration appBarConfiguration
              = new AppBarConfiguration.Builder(navController.getGraph()).build();
      NavigationUI.setupWithNavController(toolbar, navController,appBarConfiguration);

      setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      Log.d(TAG, "onCreateOptionsMenu() called");
      getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      Log.d(TAG, "onOptionsItemSelected() called");
      switch(item.getItemId()){
          case R.id.about:{
            Log.d(TAG, "onOptionsItemSelected(): show about dialog");
            navigate(R.id.action_global_about);
            return true;
          }
          case android.R.id.home:{
            Log.d(TAG, "onOptionsItemSelected(): navigate to home");
            navigate(R.id.action_global_list);
            return true;
          }
          default: {
              return super.onOptionsItemSelected(item);
          }
      }
    }

  private void navigate(int action) {
    Log.d(TAG, "navigate() called");
    Navigation.findNavController(this, R.id.nav_host_fragment)
            .navigate(action);
  }

}
