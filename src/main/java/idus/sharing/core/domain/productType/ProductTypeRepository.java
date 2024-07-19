package idus.sharing.core.domain.productType;

import java.util.Optional;

public interface ProductTypeRepository {
  Optional<ProductType> findById(int id);
}
