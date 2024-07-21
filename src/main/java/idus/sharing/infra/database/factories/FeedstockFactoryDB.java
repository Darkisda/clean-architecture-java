package idus.sharing.infra.database.factories;

import idus.sharing.application.adapters.AbstractEntityFactory;
import idus.sharing.core.domain.feedstock.Feedstock;
import idus.sharing.infra.database.entities.FeedstockDB;

public class FeedstockFactoryDB extends AbstractEntityFactory<Feedstock, FeedstockDB> {
  public static Feedstock handleBuildToModel(FeedstockDB tdb) {
    var feedstock = new Feedstock();
    feedstock.setId(tdb.getId());
    feedstock.setName(tdb.getName());
    feedstock.setCode(tdb.getCode());

    return feedstock;
  };

  public static FeedstockDB handleBuildFromModel(Feedstock t) {
    var feedstockDB = new FeedstockDB();
    feedstockDB.setId(t.getId());
    feedstockDB.setName(t.getName());
    feedstockDB.setCode(t.getCode());

    return feedstockDB;
  };
}
