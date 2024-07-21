package idus.sharing.infra.database.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import idus.sharing.application.datamappers.RawFeedstock;
import idus.sharing.infra.database.entities.FeedstockDB;

public interface FeedstockRepositoryJPA extends JpaRepository<FeedstockDB, Integer> {

  @Query(value = "SELECT f.id, f.name, f.code FROM public.feedstock f", nativeQuery = true)
  List<RawFeedstock> findAllWithoutProduct();

  @Query(value = "SELECT " +
      "f.id, f.name, f.code, " +
      "( " +
      "SELECT json_agg(" +
      "json_build_object(" +
      "'properties', (SELECT json_agg(json_build_object('name', pp.name, 'id', pp.id)) FROM public.property pp LEFT JOIN public.product_properties ppps on pp.id = ppps.properties_id AND ppps.product_id = p.id), "
      +
      "'type', json_build_object('name', pt.name, 'id', pt.id, 'code', pt.code), " +
      "'isOrganic', p.is_organic, " +
      "'id', p.id, " +
      "'correspondingCode', p.corresponding_code" +
      ") " +
      ") " +
      "FROM public.product p " +
      "LEFT JOIN public.product_type pt on p.type_id = pt.id " +
      "WHERE p.feedstock_id = f.id" +
      ") AS produtos " +
      "FROM public.feedstock f WHERE f.id = ?1", nativeQuery = true)
  Optional<FeedstockDB> findWithProductById(Integer id);
}
