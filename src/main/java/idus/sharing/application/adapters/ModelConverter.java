package idus.sharing.application.adapters;

public interface ModelConverter<T, DBT> {
  public T converterToModel();

  public DBT newInstanceFromModel(T t);
}
