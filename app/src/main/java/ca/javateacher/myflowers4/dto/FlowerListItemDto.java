package ca.javateacher.myflowers4.dto;

// used to present flower data to the list fragment
public class FlowerListItemDto {

  private int mId;
  private String mLabel;
  private String mImage;

  public FlowerListItemDto(int id, String label, String image) {
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
