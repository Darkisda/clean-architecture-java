package idus.sharing.core.usecases.ports.inputs;

import java.util.List;

public record CreateProductInput(Integer feedstockId, Integer productTypeId, List<Integer> propertiesId,
    Boolean isOrganic) {

}
