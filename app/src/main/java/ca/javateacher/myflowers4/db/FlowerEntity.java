package ca.javateacher.myflowers4.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import ca.javateacher.myflowers4.model.Flower;

@Entity(tableName = "flowers")
public class FlowerEntity implements Flower {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name="id")
  private long mId = 0;

  @ColumnInfo(name="name")
  private String mName;

  @ColumnInfo(name="label")
  private String mLabel;

  @ColumnInfo(name="description")
  private String mDescription;

  @ColumnInfo(name="uri")
  private String mUri;

  // the default constructor, it is used by Room
  public FlowerEntity(){
    // nothing
  }

  /*
   * This constructor is annotated using @Ignore, because Room expects only
   * one constructor by default in an entity class.
   */
  @Ignore
  public FlowerEntity(String name, String label, String description, String uri) {
    mName = name;
    mLabel = label;
    mDescription = description;
    mUri = uri;
  }

  @Override
  public long getId() {
    return mId;
  }

  public void setId(long id) {
    mId = id;
  }

  @Override
  public String getName() {
    return mName;
  }

  public void setName(String name) {
    mName = name;
  }

  @Override
  public String getLabel() {
    return mLabel;
  }

  public void setLabel(String label) {
    mLabel = label;
  }

  @Override
  public String getDescription() {
    return mDescription;
  }

  public void setDescription(String description) {
    mDescription = description;
  }

  @Override
  public String getUri() {
    return mUri;
  }

  public void setUri(String uri) {
    mUri = uri;
  }
}
