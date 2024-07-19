package idus.sharing.infra.database.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import idus.sharing.core.domain.feedstock.Feedstock;
import idus.sharing.core.domain.feedstock.FeedstockRepository;

public class FeedstockRepositoryMock implements FeedstockRepository {
  private List<Feedstock> data;

  public FeedstockRepositoryMock() {
    this.data = new ArrayList<Feedstock>();
    this.data.add(new Feedstock(1, "Abacate", 1));
  }

  @Override
  public Optional<Feedstock> findById(int id) {
    return this.data.stream().filter(feedstock -> feedstock.getId() == id).findFirst();
  }
}
