package idus.sharing.infra.database.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import idus.sharing.core.domain.feedstock.Feedstock;
import idus.sharing.core.domain.feedstock.FeedstockRepository;
import idus.sharing.infra.database.factories.FeedstockFactoryDB;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FeedstockRepositoryImp implements FeedstockRepository {
  private final FeedstockRepositoryJPA repositoryJPA;

  @Override
  public Optional<Feedstock> findById(int id) {
    var feedstock = this.repositoryJPA.findById(id);
    if (!feedstock.isPresent()) {
      return Optional.empty();
    }
    return Optional.of(FeedstockFactoryDB.handleBuildToModel(feedstock.get()));
  }

  @Override
  public List<Feedstock> listFeedstockWithoutProducts() {
    var feedstocks = this.repositoryJPA.findAllWithoutProduct();
    return feedstocks.stream()
        .map(f -> {
          var feedstockDB = new Feedstock();
          feedstockDB.setId(f.getId());
          feedstockDB.setCode(f.getCode());
          feedstockDB.setName(f.getName());
          feedstockDB.setProducts(new ArrayList<>());
          return feedstockDB;
        }).toList();
  }

  @Override
  public Feedstock save(Feedstock f) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }
}
