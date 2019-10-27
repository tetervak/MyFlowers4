package ca.javateacher.myflowers4.di;

import ca.javateacher.myflowers4.domain.FlowerDetailsInter;
import ca.javateacher.myflowers4.domain.FlowerDetailsInterImpl;
import ca.javateacher.myflowers4.domain.FlowerListInter;
import ca.javateacher.myflowers4.domain.FlowerListInterImpl;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class FlowerDomainModule {

  @Binds
  public abstract FlowerListInter bindFlowerListInter(FlowerListInterImpl listInter);

  @Binds
  public abstract FlowerDetailsInter bindFlowerDetailsInter(FlowerDetailsInterImpl detailsInter);
}
