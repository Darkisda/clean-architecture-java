package idus.sharing.application.adapters;

public class AbstractEntityFactory<T, TDB> {
  public static <T, TDB> T handleBuildToModel(TDB tdb) {
    return null;
  };

  public static <T, TDB> TDB handleBuildFromModel(T t) {
    return null;
  };
}