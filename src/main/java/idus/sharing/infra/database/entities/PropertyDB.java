package idus.sharing.infra.database.entities;

import idus.sharing.application.adapters.ModelConverter;
import idus.sharing.core.domain.property.Property;
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
@Table(name = "property")
public class PropertyDB implements ModelConverter<Property> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  @Column(nullable = false)
  private String name;

  @Override
  public Property converter() {
    return new Property(this.id, this.name);
  }
}
