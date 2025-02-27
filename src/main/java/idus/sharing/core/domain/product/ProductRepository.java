package idus.sharing.core.domain.product;

import java.util.Optional;

public interface ProductRepository {
  Optional<Product> findById(int id);

  Product save(Product p);
}
