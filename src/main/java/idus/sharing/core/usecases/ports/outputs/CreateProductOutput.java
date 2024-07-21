package idus.sharing.core.usecases.ports.outputs;

import java.util.List;

public record CreateProductOutput(int id, String correspondingCode, Boolean isOrganic, TypeListOutput type,
    List<PropertyListOutput> properties) {

}
