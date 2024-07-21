package idus.sharing.infra.database.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feedstock")
@Data
@NoArgsConstructor
public class FeedstockDB {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Integer code;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "feedstock")
  private List<ProductDB> products;
}
