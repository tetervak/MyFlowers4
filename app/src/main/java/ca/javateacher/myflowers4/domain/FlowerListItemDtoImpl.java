package ca.javateacher.myflowers4.domain;

public class FlowerListItemDtoImpl implements FlowerListItemDto{
  private int mId;
  private String mLabel;
  private String mImage;

  public FlowerListItemDtoImpl(int id, String label, String image) {
    mId = id;
    mLabel = label;
    mImage = image;
  }

  public int getId() {
    return mId;
  }

  public String getLabel() {
    return mLabel;
  }

  public String getImage() {
    return mImage;
  }
}
