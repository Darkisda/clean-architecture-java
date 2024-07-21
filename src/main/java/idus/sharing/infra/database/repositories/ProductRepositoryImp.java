package idus.sharing.infra.database.repositories;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import idus.sharing.core.domain.product.Product;
import idus.sharing.core.domain.product.ProductRepository;
import idus.sharing.infra.database.factories.ProductFactoryDB;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImp implements ProductRepository {
  private final ProductRepositoryJPA repositoryJPA;
  private final Logger log = LoggerFactory.getLogger(ProductRepositoryImp.class);

  @Override
  public Optional<Product> findById(int id) {
    var product = this.repositoryJPA.findById(id);
    if (!product.isPresent()) {
      return Optional.empty();
    }
    return Optional.of(ProductFactoryDB.handleBuildToModel(product.get()));
  }

  @Override
  public Product save(Product p) {
    this.log.info("ALOOOOOOOOOOOOOOOOOOOOOOOO!!!!!!!!!!!!!!!!!!");
    this.log.info(p.getType().getName());
    var productModel = ProductFactoryDB.handleBuildFromModel(p);
    this.log.info(productModel.getType().getName());

    return ProductFactoryDB.handleBuildToModel(this.repositoryJPA.save(productModel));
  }

}
