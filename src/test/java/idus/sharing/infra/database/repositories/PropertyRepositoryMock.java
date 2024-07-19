package idus.sharing.infra.database.repositories;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import idus.sharing.core.domain.property.Property;
import idus.sharing.core.domain.property.PropertyRepository;

public class PropertyRepositoryMock implements PropertyRepository {
  private List<Property> data;

  public PropertyRepositoryMock() {
    this.data = new ArrayList<Property>();
    this.data.add(new Property(1, "Antioxidante"));
    this.data.add(new Property(2, "Hidratante"));
  }

  @Override
  public Optional<Property> findById(int id) {
    return this.data.stream().filter(property -> property.getId() == id).findFirst();
  }

}
