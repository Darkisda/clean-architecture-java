package idus.sharing.infra.database.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import idus.sharing.core.domain.productType.ProductType;
import idus.sharing.core.domain.productType.ProductTypeRepository;

public class ProductTypeRepositoryMock implements ProductTypeRepository {
  private List<ProductType> data;

  public ProductTypeRepositoryMock() {
    this.data = new ArrayList<ProductType>();
    this.data.add(new ProductType(1, "Manteiga", 1));
    this.data.add(new ProductType(2, "Óleo", 2));
  }

  @Override
  public Optional<ProductType> findById(int id) {
    return this.data.stream().filter(type -> type.getId() == id).findFirst();
  }

}
