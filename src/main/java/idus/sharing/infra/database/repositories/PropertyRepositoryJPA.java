package idus.sharing.infra.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import idus.sharing.infra.database.entities.PropertyDB;

public interface PropertyRepositoryJPA extends JpaRepository<PropertyDB, Integer>{
  
}
