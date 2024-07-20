package idus.sharing.core.domain.feedstock;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import idus.sharing.core.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedstock {
  private int id;
  private String name;
  private Integer code;
  private List<Product> product = new ArrayList<>();

  public String getFormattedCode() {
    var formatter = new DecimalFormat("0000");
    return formatter.format(this.code);
  }
}
