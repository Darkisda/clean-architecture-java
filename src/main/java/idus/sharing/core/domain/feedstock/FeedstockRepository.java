package idus.sharing.core.domain.feedstock;

import java.util.List;
import java.util.Optional;

public interface FeedstockRepository {
  Optional<Feedstock> findById(int id);

  List<Feedstock> listFeedstockWithoutProducts();

  Feedstock save(Feedstock f);
}
