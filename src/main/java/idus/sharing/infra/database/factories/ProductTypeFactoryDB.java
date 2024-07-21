package idus.sharing.infra.database.factories;

import idus.sharing.application.adapters.AbstractEntityFactory;
import idus.sharing.core.domain.productType.ProductType;
import idus.sharing.infra.database.entities.ProductTypeDB;

public class ProductTypeFactoryDB extends AbstractEntityFactory<ProductType, ProductTypeDB> {

  public static ProductType handleBuildToModel(ProductTypeDB tdb) {
    var productType = new ProductType();
    productType.setId(tdb.getId());
    productType.setCode(tdb.getCode());
    productType.setName(tdb.getName());
    return productType;
  };

  public static ProductTypeDB handleBuildFromModel(ProductType t) {
    var productTypeDB = new ProductTypeDB();
    productTypeDB.setId(t.getId());
    productTypeDB.setCode(t.getCode());
    productTypeDB.setName(t.getName());
    return productTypeDB;
  };
}
