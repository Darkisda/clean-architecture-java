package idus.sharing.core.domain.product;

import java.util.List;

import idus.sharing.core.domain.feedstock.Feedstock;
import idus.sharing.core.domain.productType.ProductType;
import idus.sharing.core.domain.property.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  private int id;
  private String correspondingCode;
  private Boolean isOrganic;
  private Feedstock feedstock;
  private ProductType type;
  private List<Property> properties;
}
