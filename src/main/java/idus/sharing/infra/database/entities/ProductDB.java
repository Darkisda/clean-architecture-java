package idus.sharing.infra.database.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class ProductDB {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  @Column(nullable = false)
  private String correspondingCode;

  @Column(nullable = false)
  private Boolean isOrganic;

  @ManyToOne
  @JoinColumn(name = "feedstock_id", nullable = false)
  private FeedstockDB feedstock;

  @ManyToOne
  @JoinColumn(name = "type_id", nullable = false)
  private ProductTypeDB type;

  @ManyToMany
  @JoinTable(name = "product_properties", joinColumns = @JoinColumn(name = "properties_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<PropertyDB> properties;
}
