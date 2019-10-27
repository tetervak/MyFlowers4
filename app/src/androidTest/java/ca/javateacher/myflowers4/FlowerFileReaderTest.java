package ca.javateacher.myflowers4;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import ca.javateacher.myflowers4.domain.Flower;
import ca.javateacher.myflowers4.repository.FlowerFileReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class FlowerFileReaderTest {

  private FlowerFileReader mFlowerFileReader;

  @Before
  public void setup(){
    Context appContext = InstrumentationRegistry.getInstrumentation()
        .getTargetContext().getApplicationContext();
    TestComponent component = DaggerTestComponent.factory().create(appContext);
    mFlowerFileReader = component.getFlowerFileReader();
  }

  @Test
  public void testFlowerListGenerator(){
    assertNotNull(mFlowerFileReader);
    List<Flower> list = mFlowerFileReader.getFlowerListSync();
    assertFalse(list.isEmpty());
    assertEquals(list.size(), 5);
  }

}
