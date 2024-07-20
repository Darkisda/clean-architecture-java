package idus.sharing.infra.services;

import java.util.List;

import org.springframework.stereotype.Service;

import idus.sharing.core.domain.property.Property;
import idus.sharing.infra.database.repositories.PropertyRepositoryJPA;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PropertyService {
  private final PropertyRepositoryJPA repositoryJPA;

  public List<Property> findAll() {
    return this.repositoryJPA.findAll().stream().map(p -> new Property(p.getId(), p.getName())).toList();
  }
}
