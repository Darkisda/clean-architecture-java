package idus.sharing.infra.database.entities;

import java.util.List;

import idus.sharing.application.adapters.ModelConverter;
import idus.sharing.core.domain.feedstock.Feedstock;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feedstock")
@Data
@NoArgsConstructor
public class FeedstockDB implements ModelConverter<Feedstock> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Integer code;

  @OneToMany
  @JoinColumn(name = "feedstock_id")
  private List<ProductDB> products;

  @Override
  public Feedstock converter() {
    return new Feedstock(this.id, this.name, this.code, this.products.stream().map(p -> p.converter()).toList());
  }
}
