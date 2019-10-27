package ca.javateacher.myflowers4.domain;

// data transfer object,
// used to present flower data to the list fragment
public interface FlowerListItemDto {
  int getId();
  String getLabel();
  String getImage();
}
