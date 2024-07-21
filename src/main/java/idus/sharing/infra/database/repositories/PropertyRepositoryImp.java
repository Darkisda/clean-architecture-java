package idus.sharing.infra.database.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import idus.sharing.core.domain.property.Property;
import idus.sharing.core.domain.property.PropertyRepository;
import idus.sharing.infra.database.factories.PropertyFactoryDB;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PropertyRepositoryImp implements PropertyRepository {
  private final PropertyRepositoryJPA repositoryJPA;

  @Override
  public Optional<Property> findById(int id) {
    var property = this.repositoryJPA.findById(id);
    if (!property.isPresent()) {
      return Optional.empty();
    }
    return Optional.of(PropertyFactoryDB.handleBuildToModel(property.get()));
  }
}
