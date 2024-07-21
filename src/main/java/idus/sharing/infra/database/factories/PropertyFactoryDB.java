package idus.sharing.infra.database.factories;

import java.util.ArrayList;
import java.util.List;

import idus.sharing.application.adapters.AbstractEntityFactory;
import idus.sharing.core.domain.property.Property;
import idus.sharing.infra.database.entities.PropertyDB;

public class PropertyFactoryDB extends AbstractEntityFactory<Property, PropertyDB> {
  public static Property handleBuildToModel(PropertyDB tdb) {
    var property = new Property();
    property.setId(tdb.getId());
    property.setName(tdb.getName());
    return property;
  };

  public static PropertyDB handleBuildFromModel(Property t) {
    var propertyDB = new PropertyDB();
    propertyDB.setId(t.getId());
    propertyDB.setName(t.getName());
    return propertyDB;
  };

  public static List<PropertyDB> newListFromModel(List<Property> listProperties) {
    List<PropertyDB> propertyDBList = new ArrayList<>();
    for (Property property : listProperties) {
      var propertyDB = new PropertyDB();
      propertyDB.setId(property.getId());
      propertyDB.setName(property.getName());
      propertyDBList.add(propertyDB);
    }
    return propertyDBList;
  }

  public static List<Property> newListToModel(List<PropertyDB> listPropertiesDB) {
    List<Property> propertyList = new ArrayList<>();
    for (PropertyDB property : listPropertiesDB) {
      var propertyDB = new Property();
      propertyDB.setId(property.getId());
      propertyDB.setName(property.getName());
      propertyList.add(propertyDB);
    }
    return propertyList;
  }
}
