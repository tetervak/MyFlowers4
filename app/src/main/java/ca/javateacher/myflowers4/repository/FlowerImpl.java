package ca.javateacher.myflowers4.repository;

import ca.javateacher.myflowers4.domain.Flower;

public class FlowerImpl implements Flower {

  private long mId = 0;
  private String mName;
  private String mLabel;
  private String mDescription;
  private String mUri;

  public FlowerImpl(String name, String label, String description, String uri) {
    mName = name;
    mLabel = label;
    mDescription = description;
    mUri = uri;
  }

  @Override
  public long getId() {
    return mId;
  }

  @Override
  public String getName() {
    return mName;
  }

  @Override
  public String getLabel() {
    return mLabel;
  }

  @Override
  public String getDescription() {
    return mDescription;
  }

  @Override
  public String getUri() {
    return mUri;
  }
}
