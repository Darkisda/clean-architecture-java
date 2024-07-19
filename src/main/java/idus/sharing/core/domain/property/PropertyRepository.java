package idus.sharing.core.domain.property;

import java.util.Optional;

public interface PropertyRepository {
  Optional<Property> findById(int id);
}
