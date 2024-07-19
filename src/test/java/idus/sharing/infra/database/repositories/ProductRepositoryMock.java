package idus.sharing.infra.database.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import idus.sharing.core.domain.product.Product;
import idus.sharing.core.domain.product.ProductRepository;

public class ProductRepositoryMock implements ProductRepository {
  private int id = 1;
  private List<Product> data;

  public ProductRepositoryMock() {
    this.data = new ArrayList<Product>();
  }

  @Override
  public Optional<Product> findById(int id) {
    return this.data.stream().filter(product -> product.getId() == id).findFirst();
  }

  @Override
  public Product save(Product p) {
    p.setId(id);
    this.data.add(p);
    id++;
    return p;
  }

}
