package idus.sharing.infra.database.factories;

import java.util.ArrayList;

import idus.sharing.application.adapters.AbstractEntityFactory;
import idus.sharing.core.domain.feedstock.Feedstock;
import idus.sharing.infra.database.entities.FeedstockDB;

public class FeedstockFactoryDB extends AbstractEntityFactory<Feedstock, FeedstockDB> {
  public static Feedstock handleBuildToModel(FeedstockDB tdb) {
    var feedstock = new Feedstock();
    feedstock.setId(tdb.getId());
    feedstock.setName(tdb.getName());
    feedstock.setCode(tdb.getCode());
    if (tdb.getProducts().size() > 0) {
      feedstock.setProducts(
          tdb.getProducts().stream().map((product) -> ProductFactoryDB.handleBuildToModel(product)).toList());
    } else {
      feedstock.setProducts(new ArrayList<>());
    }
    return feedstock;
  };

  public static FeedstockDB handleBuildFromModel(Feedstock t) {
    var feedstockDB = new FeedstockDB();
    feedstockDB.setId(t.getId());
    feedstockDB.setName(t.getName());
    feedstockDB.setCode(t.getCode());
    if (t.getProducts().size() > 0) {
      feedstockDB.setProducts(
          t.getProducts().stream().map((product) -> ProductFactoryDB.handleBuildFromModel(product)).toList());
    } else {
      feedstockDB.setProducts(new ArrayList<>());
    }
    return feedstockDB;
  };
}
