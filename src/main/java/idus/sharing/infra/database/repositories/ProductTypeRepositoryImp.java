package idus.sharing.infra.database.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import idus.sharing.core.domain.productType.ProductType;
import idus.sharing.core.domain.productType.ProductTypeRepository;
import idus.sharing.infra.database.factories.ProductTypeFactoryDB;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductTypeRepositoryImp implements ProductTypeRepository {
  private final ProductTypeRepositoryJPA repositoryJPA;

  @Override
  public Optional<ProductType> findById(int id) {
    var productType = this.repositoryJPA.findById(id);
    if (!productType.isPresent()) {
      return Optional.empty();
    }
    return Optional.of(ProductTypeFactoryDB.handleBuildToModel(productType.get()));
  }
}
