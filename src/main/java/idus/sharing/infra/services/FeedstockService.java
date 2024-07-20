package idus.sharing.infra.services;

import java.util.List;

import org.springframework.stereotype.Service;

import idus.sharing.core.usecases.ports.outputs.FeedstockListOutput;
import idus.sharing.infra.database.repositories.FeedstockRepositoryJPA;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedstockService {
  private final FeedstockRepositoryJPA repositoryJPA;

  public List<FeedstockListOutput> findAll() {
    var feedstocksJPA = this.repositoryJPA.findAll();
    return feedstocksJPA.stream().map(f -> {
      return new FeedstockListOutput(f.getId(), f.getName(), f.converter().getFormattedCode());
    }).toList();
  }
}
