package ca.javateacher.myflowers4.di;

import ca.javateacher.myflowers4.repository.FlowerFileReader;
import ca.javateacher.myflowers4.repository.FlowerInitRepository;
import ca.javateacher.myflowers4.repository.FlowerRepository;
import ca.javateacher.myflowers4.repository.FlowerRepositoryImpl;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class FlowerRepositoryModule {

  @Binds
  public abstract FlowerRepository bindFlowerRepository(FlowerRepositoryImpl flowerRepository);

  @Binds
  public abstract FlowerInitRepository bindFlowerInitRepository(FlowerFileReader fileReader);
  //public abstract FlowerInitRepository bindFlowerInitRepository(FlowerListGenerator listGenerator);
}
