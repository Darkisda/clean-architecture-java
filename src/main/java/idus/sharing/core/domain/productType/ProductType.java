package idus.sharing.core.domain.productType;

import java.text.DecimalFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductType {
  private int id;
  private String name;
  private Integer code;

  public String getFormattedCode() {
    var formatter = new DecimalFormat("0000");
    return formatter.format(this.code);
  }
}
