package idus.sharing.infra.services;

import org.springframework.stereotype.Service;

import idus.sharing.core.domain.product.Product;
import idus.sharing.core.usecases.CreateProduct;
import idus.sharing.core.usecases.ports.inputs.CreateProductInput;
import idus.sharing.infra.database.repositories.FeedstockRepositoryImp;
import idus.sharing.infra.database.repositories.ProductRepositoryImp;
import idus.sharing.infra.database.repositories.ProductTypeRepositoryImp;
import idus.sharing.infra.database.repositories.PropertyRepositoryImp;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepositoryImp repositoryImp;
  private final FeedstockRepositoryImp feedstockRepositoryImp;
  private final ProductTypeRepositoryImp productTypeRepositoryImp;
  private final PropertyRepositoryImp propertyRepositoryImp;

  public Product create(CreateProductInput input) {
    var useCase = new CreateProduct(this.repositoryImp, this.feedstockRepositoryImp, this.productTypeRepositoryImp,
        this.propertyRepositoryImp);
    return useCase.exec(input);
  }
}
