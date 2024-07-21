package idus.sharing.infra.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import idus.sharing.application.datamappers.RawFeedstock;
import idus.sharing.infra.database.entities.FeedstockDB;

public interface FeedstockRepositoryJPA extends JpaRepository<FeedstockDB, Integer> {

  @Query(value = "SELECT f.id, f.name, f.code FROM public.feedstock f", nativeQuery = true)
  List<RawFeedstock> findAllWithoutProduct();
}
