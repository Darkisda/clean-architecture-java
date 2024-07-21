package idus.sharing.core.usecases;

import java.util.List;

import idus.sharing.core.domain.feedstock.FeedstockRepository;
import idus.sharing.core.usecases.ports.outputs.FeedstockListOutput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListFeedstock {
  private final FeedstockRepository repository;

  public List<FeedstockListOutput> exec() {
    return this.repository.listFeedstockWithoutProducts().stream()
        .map(f -> new FeedstockListOutput(f.getId(), f.getName(), f.getFormattedCode())).toList();
  }
}
