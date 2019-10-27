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

  @Override
  public int getId() {
    return mId;
  }

  @Override
  public String getLabel() {
    return mLabel;
  }

  @Override
  public String getImage() {
    return mImage;
  }
}
