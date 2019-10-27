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

  public int getId() {
    return mId;
  }

  public String getLabel() {
    return mLabel;
  }

  public String getDescription() {
    return mDescription;
  }

  public String getUri() {
    return mUri;
  }

  public String getImage() {
    return mImage;
  }
}
