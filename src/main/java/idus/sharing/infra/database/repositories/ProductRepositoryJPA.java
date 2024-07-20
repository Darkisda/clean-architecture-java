package idus.sharing.infra.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import idus.sharing.infra.database.entities.ProductDB;

public interface ProductRepositoryJPA extends JpaRepository<ProductDB, Integer> {

}
