package ca.javateacher.myflowers4.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import ca.javateacher.myflowers4.db.FlowerDao;
import ca.javateacher.myflowers4.db.FlowerEntity;
import ca.javateacher.myflowers4.model.Flower;

@Singleton
public class FlowerRepositoryImpl implements FlowerRepository {

  private static final String TAG = "FlowerRepositoryImpl";

  private FlowerDao mFlowerDao;
  private FlowerInitRepository mFlowerInitRepository;

  @Inject
  public FlowerRepositoryImpl(FlowerInitRepository flowerInitRepository, FlowerDao flowerDao) {
    Log.d(TAG, "FlowerRepositoryImpl() called");
    mFlowerInitRepository = flowerInitRepository;
    mFlowerDao = flowerDao;
    reset();
  }

  private void reset(){
    Thread thread = new Thread(() -> {
      mFlowerDao.deleteAllFlowers();
      List<Flower> flowers
          = mFlowerInitRepository.getFlowerListSync();
      mFlowerDao.insertFlowers(flowers2Entities(flowers));
    });
    thread.start();
  }

  @Override
  public void loadFileData(){
    Thread thread = new Thread(() -> {
      List<Flower> flowers = mFlowerInitRepository.getFlowerListSync();
      mFlowerDao.insertFlowers(flowers2Entities(flowers));
    });
    thread.start();
  }

  @NonNull
  private List<FlowerEntity> flowers2Entities(@NonNull List<Flower> flowers){
    List<FlowerEntity> entities = new ArrayList<>();
    for(Flower flower: flowers){
      entities.add(flower2Entity(flower));
    }
    return entities;
  }

  @NonNull
  private FlowerEntity flower2Entity(@NonNull Flower flower){
    FlowerEntity entity = new FlowerEntity();
    entity.setId(flower.getId());
    entity.setName(flower.getName());
    entity.setLabel(flower.getLabel());
    entity.setDescription(flower.getDescription());
    entity.setUri(flower.getUri());
    return entity;
  }

  @NonNull
  private List<Flower> entities2Flowers(@NonNull List<FlowerEntity> entities){
    return new ArrayList<>(entities);
  }

  @Override
  public void clearAllData(){
    Thread thread = new Thread(() -> mFlowerDao.deleteAllFlowers());
    thread.start();
  }

  @Override
  @NonNull
  public LiveData<List<Flower>> getFlowerListData(){
    return
        Transformations.map(mFlowerDao.getFlowerListData(),this::entities2Flowers);
  }

  @Override
  @NonNull
  public LiveData<Flower> getFlowerDataById(int id) {
    return
        Transformations.map(mFlowerDao.getFlowerDataById(id),entity->entity);
  }

  @Override
  public void deleteFlowerById(int id){
    Thread thread = new Thread(() -> mFlowerDao.deleteFlowerById(id));
    thread.start();
  }
}
