package idus.sharing.infra.database.entities;

import idus.sharing.application.adapters.ModelConverter;
import idus.sharing.core.domain.productType.ProductType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product_type")
public class ProductTypeDB implements ModelConverter<ProductType> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Integer code;

  @Override
  public ProductType converter() {
    return new ProductType(this.id, this.name, this.code);
  }
}
