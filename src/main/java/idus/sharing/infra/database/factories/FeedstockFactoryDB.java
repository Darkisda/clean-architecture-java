package idus.sharing.infra.database.factories;

import idus.sharing.core.domain.feedstock.Feedstock;
import idus.sharing.infra.database.entities.FeedstockDB;

public class FeedstockFactoryDB {
  public static Feedstock handleBuildToModel(FeedstockDB tdb) {
    var feedstock = new Feedstock();
    feedstock.setId(tdb.getId());
    feedstock.setName(tdb.getName());
    feedstock.setCode(tdb.getCode());

    return feedstock;
  };

  public static Feedstock handleBuildWithProductsToModel(FeedstockDB tdb) {
    var feedstock = new Feedstock();
    feedstock.setId(tdb.getId());
    feedstock.setName(tdb.getName());
    feedstock.setCode(tdb.getCode());
    feedstock.setProducts(tdb.getProducts().stream().map(p -> ProductFactoryDB.handleBuildToModel(p)).toList());
    return feedstock;
  };

  public static FeedstockDB handleBuildFromModel(Feedstock t) {
    var feedstockDB = new FeedstockDB();
    feedstockDB.setId(t.getId());
    feedstockDB.setName(t.getName());
    feedstockDB.setCode(t.getCode());

    return feedstockDB;
  };

  public static FeedstockDB handleBuildWithProductsFromModel(Feedstock t) {
    var feedstockDB = new FeedstockDB();
    feedstockDB.setId(t.getId());
    feedstockDB.setName(t.getName());
    feedstockDB.setCode(t.getCode());
    feedstockDB.setProducts(t.getProducts().stream().map(p -> ProductFactoryDB.handleBuildFromModel(p)).toList());
    return feedstockDB;
  };
}
