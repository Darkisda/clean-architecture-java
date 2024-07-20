package idus.sharing.infra.services;

import java.util.List;

import org.springframework.stereotype.Service;

import idus.sharing.core.domain.feedstock.Feedstock;
import idus.sharing.infra.database.repositories.FeedstockRepositoryJPA;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedstockService {
  private final FeedstockRepositoryJPA repositoryJPA;

  public List<Feedstock> findAll() {
    var feedstocksJPA = this.repositoryJPA.findAll();
    return feedstocksJPA.stream().map(f -> new Feedstock(f.getId(), f.getName(), f.getCode())).toList();
  }
}
