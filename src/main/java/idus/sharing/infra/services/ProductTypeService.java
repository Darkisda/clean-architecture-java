package idus.sharing.infra.services;

import java.util.List;

import org.springframework.stereotype.Service;

import idus.sharing.core.domain.productType.ProductType;
import idus.sharing.infra.database.repositories.ProductTypeRepositoryJPA;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductTypeService {
  private final ProductTypeRepositoryJPA repositoryJPA;

  public List<ProductType> findAll() {
    var productTypesJPA = this.repositoryJPA.findAll();
    return productTypesJPA.stream().map(pt -> new ProductType(pt.getId(), pt.getName(), pt.getCode())).toList();
  }
}
