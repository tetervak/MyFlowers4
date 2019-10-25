package ca.javateacher.myflowers4;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlowerInstrumentedTest {

    private Context mContext;

    @Before
    public void setContext(){
        mContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @Test
    public void testAppContext() {
        assertEquals("ca.javateacher.myflowers2", mContext.getPackageName());
    }

}
