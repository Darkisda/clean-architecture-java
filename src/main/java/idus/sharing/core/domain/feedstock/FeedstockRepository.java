package idus.sharing.core.domain.feedstock;

import java.util.Optional;

public interface FeedstockRepository {
  Optional<Feedstock> findById(int id);
}
