package idus.sharing.infra.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import idus.sharing.infra.database.entities.ProductTypeDB;

public interface ProductTypeRepositoryJPA extends JpaRepository<ProductTypeDB, Integer>{
  
}
