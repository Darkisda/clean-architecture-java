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
import idus.sharing.core.usecases.ports.outputs.CreateProductOutput;
import idus.sharing.core.usecases.ports.outputs.PropertyListOutput;
import idus.sharing.core.usecases.ports.outputs.TypeListOutput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProduct {
  private final ProductRepository repository;
  private final FeedstockRepository feedstockRepository;
  private final ProductTypeRepository productTypeRepository;
  private final PropertyRepository propertyRepository;

  public CreateProductOutput exec(CreateProductInput input) {
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
    product.setFeedstock(feedstock);

    var p = this.repository.save(product);

    return new CreateProductOutput(p.getId(), p.getCorrespondingCode(), p.getIsOrganic(),
        new TypeListOutput(p.getType().getId(), p.getType().getName(), p.getType().getFormattedCode()),
        p.getProperties()
            .stream().map(property -> new PropertyListOutput(property.getId(), property.getName())).toList());
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
