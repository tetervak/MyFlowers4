package ca.javateacher.myflowers4;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

import ca.javateacher.myflowers4.model.Flower;
import ca.javateacher.myflowers4.repository.FlowerListGenerator;

public class FlowerListGeneratorTest {

  private FlowerListGenerator mFlowerListGenerator;

  @Before
  public void setup(){
    Context appContext = InstrumentationRegistry.getInstrumentation()
        .getTargetContext().getApplicationContext();
    TestComponent component = DaggerTestComponent.factory().create(appContext);
    mFlowerListGenerator = component.getFlowerListGenerator();
  }

  @Test
  public void testFlowerListGenerator(){
    assertNotNull(mFlowerListGenerator);
    List<Flower> list = mFlowerListGenerator.getFlowerListSync();
    assertFalse(list.isEmpty());
    assertEquals(list.size(), 5);
  }

}
