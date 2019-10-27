package ca.javateacher.myflowers4.domain;

public class FlowerDetailsDtoImpl implements FlowerDetailsDto{

  private int mId;
  private String mLabel;
  private String mDescription;
  private String mUri;
  private String mImage;

  public FlowerDetailsDtoImpl(int id, String label,
                          String description, String uri,
                          String image) {
    mId = id;
    mLabel = label;
    mDescription = description;
    mUri = uri;
    mImage = image;
  }

  @Override
  public int getId() {
    return mId;
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

  @Override
  public String getImage() {
    return mImage;
  }
}
