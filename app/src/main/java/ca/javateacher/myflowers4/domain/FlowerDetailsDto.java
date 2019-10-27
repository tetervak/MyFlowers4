package ca.javateacher.myflowers4.domain;

// data transfer object,
// used to present flower data to the details fragment
public interface FlowerDetailsDto {

  int getId();
  String getLabel();
  String getDescription();
  String getUri();
  String getImage();
}