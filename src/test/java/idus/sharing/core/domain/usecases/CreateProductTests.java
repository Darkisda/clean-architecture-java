package idus.sharing.core.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import idus.sharing.core.domain.feedstock.FeedstockRepository;
import idus.sharing.core.domain.product.ProductRepository;
import idus.sharing.core.domain.productType.ProductTypeRepository;
import idus.sharing.core.domain.property.PropertyRepository;
import idus.sharing.core.usecases.CreateProduct;
import idus.sharing.core.usecases.ports.inputs.CreateProductInput;
import idus.sharing.infra.database.repositories.FeedstockRepositoryMock;
import idus.sharing.infra.database.repositories.ProductRepositoryMock;
import idus.sharing.infra.database.repositories.ProductTypeRepositoryMock;
import idus.sharing.infra.database.repositories.PropertyRepositoryMock;

@DisplayName("Create Product usecase suite tests")
public class CreateProductTests {
  private final ProductRepository repository = new ProductRepositoryMock();
  private final FeedstockRepository feedstockRepository = new FeedstockRepositoryMock();
  private final ProductTypeRepository typeRepository = new ProductTypeRepositoryMock();
  private final PropertyRepository propertyRepository = new PropertyRepositoryMock();

  @Test
  @DisplayName("It should save a valid product")
  public void itShouldCreateAProduct() {
    var useCase = new CreateProduct(this.repository, this.feedstockRepository, this.typeRepository,
        this.propertyRepository);
    var product = useCase.exec(new CreateProductInput(1, 1, List.of(1), true));
    assertEquals(product.correspondingCode(), "0001 0001 1");
  }

  public CreateProductTests() {
  }
}
