package ca.javateacher.myflowers4.di;

import ca.javateacher.myflowers4.domain.FlowerDetailsInteractions;
import ca.javateacher.myflowers4.domain.FlowerDetailsInterImpl;
import ca.javateacher.myflowers4.domain.FlowerListInteractions;
import ca.javateacher.myflowers4.domain.FlowerListInterImpl;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class FlowerDomainModule {

  @Binds
  public abstract FlowerListInteractions bindFlowerListInter(FlowerListInterImpl listInter);

  @Binds
  public abstract FlowerDetailsInteractions bindFlowerDetailsInter(FlowerDetailsInterImpl detailsInter);
}
