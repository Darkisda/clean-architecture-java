package idus.sharing.infra.database.factories;

import idus.sharing.core.domain.product.Product;
import idus.sharing.infra.database.entities.ProductDB;

public class ProductFactoryDB {
  public static Product handleBuildToModel(ProductDB tdb) {
    var product = new Product();
    product.setId(tdb.getId());
    product.setIsOrganic(tdb.getIsOrganic());
    product.setCorrespondingCode(tdb.getCorrespondingCode());
    product.setType(ProductTypeFactoryDB.handleBuildToModel(tdb.getType()));
    product.setProperties(PropertyFactoryDB.newListToModel(tdb.getProperties()));

    return product;
  };

  public static ProductDB handleBuildFromModel(Product t) {
    var productDB = new ProductDB();
    productDB.setId(t.getId());
    productDB.setIsOrganic(t.getIsOrganic());
    productDB.setCorrespondingCode(t.getCorrespondingCode());
    productDB.setType(ProductTypeFactoryDB.handleBuildFromModel(t.getType()));
    productDB.setProperties(PropertyFactoryDB.newListFromModel(t.getProperties()));

    return productDB;
  };
}
