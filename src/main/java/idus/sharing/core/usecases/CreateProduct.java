package idus.sharing.core.usecases;

import java.util.ArrayList;
import java.util.List;

import idus.sharing.core.domain.feedstock.FeedstockRepository;
import idus.sharing.core.domain.product.Product;
import idus.sharing.core.domain.product.ProductRepository;
import idus.sharing.core.domain.productType.ProductTypeRepository;
import idus.sharing.core.domain.property.Property;
import idus.sharing.core.domain.property.PropertyRepository;
import idus.sharing.core.usecases.ports.inputs.CreateProductInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProduct {
  private final ProductRepository repository;
  private final FeedstockRepository feedstockRepository;
  private final ProductTypeRepository productTypeRepository;
  private final PropertyRepository propertyRepository;

  public Product exec(CreateProductInput input) {
    var feedstock = this.feedstockRepository.findById(input.feedstockId()).orElseThrow();
    var productType = this.productTypeRepository.findById(input.productTypeId()).orElseThrow();
    List<Property> properties = new ArrayList<Property>();

    for (Integer propertyId : input.propertiesId()) {
      var property = this.propertyRepository.findById(propertyId).orElseThrow(null);
      properties.add(property);
    }

    var correspondingCode = this.handleGenerateCorrespondingCode(feedstock.getFormattedCode(),
        productType.getFormattedCode(), input.isOrganic());
    var product = new Product();
    product.setCorrespondingCode(correspondingCode);
    product.setIsOrganic(input.isOrganic());
    product.setProperties(properties);
    product.setType(productType);

    var p = this.repository.save(product);

    return p;
  }

  private String handleGenerateCorrespondingCode(String feedstockCode, String typeCode, Boolean isOrganic) {
    var stringBuilder = new StringBuilder();
    stringBuilder.append(feedstockCode);
    stringBuilder.append(" ");
    stringBuilder.append(typeCode);
    stringBuilder.append(" ");
    stringBuilder.append(isOrganic ? "1" : "0");
    return stringBuilder.toString();
  }
}
