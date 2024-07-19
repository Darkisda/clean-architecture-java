package idus.sharing.core.usecases.adapters.inputs;

import java.util.List;

public record CreateProductInput(Integer feedstockId, Integer productTypeId, List<Integer> propertiesId, Boolean isOrganic ) {
  
}
