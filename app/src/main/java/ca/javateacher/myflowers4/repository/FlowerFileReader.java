package ca.javateacher.myflowers4.repository;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import ca.javateacher.myflowers4.domain.Flower;

@Singleton
public class FlowerFileReader extends FlowerInitRepository {

  private static final String TAG = "FlowerFileReader";

  @Inject
  public FlowerFileReader(Context context){
    super(context);
    Log.d(TAG, "FlowerFileReader() called");
  }

  @Override
  @NonNull
  public List<Flower> getFlowerListSync() {
    Log.d(TAG, "getFlowerListSync() called");
    List<Flower> flowerList = new ArrayList<>();
    try (InputStream stream = getApplicationContext().getAssets().open("data/flowers.xml")){
      DocumentBuilderFactory documentBuilderFactory =
          DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

      Document document = documentBuilder.parse(stream);
      Element documentElement = document.getDocumentElement();

      NodeList flowerNodeList = documentElement.getElementsByTagName("flower");
      for(int i = 0; i < flowerNodeList.getLength(); i++){
        Element flowerElement = (Element)flowerNodeList.item(i);
        //int id  = Integer.parseInt(flowerElement.getAttribute("id"));
        String name = flowerElement.getAttribute("name");
        String label = flowerElement.getElementsByTagName("label")
            .item(0).getTextContent();
        String description = flowerElement.getElementsByTagName("description")
            .item(0).getTextContent();
        String uri = flowerElement.getElementsByTagName("link")
            .item(0).getTextContent();
        Flower flower = new FlowerImpl(name, label, description, uri);
        flowerList.add(flower);
      }
    } catch (IOException | ParserConfigurationException | SAXException e) {
      e.printStackTrace();
    }

    return flowerList;
  }

}
