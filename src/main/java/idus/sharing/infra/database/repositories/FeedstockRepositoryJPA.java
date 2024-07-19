package idus.sharing.infra.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import idus.sharing.infra.database.entities.FeedstockDB;

public interface FeedstockRepositoryJPA extends JpaRepository<FeedstockDB, Integer> {

}
