package idus.sharing.infra.services;

import java.util.List;

import org.springframework.stereotype.Service;

import idus.sharing.core.domain.feedstock.Feedstock;
import idus.sharing.core.usecases.ListFeedstock;
import idus.sharing.core.usecases.ports.outputs.FeedstockListOutput;
import idus.sharing.infra.database.repositories.FeedstockRepositoryImp;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedstockService {
  private final FeedstockRepositoryImp repositoryJPA;

  public Feedstock findById(int id) {
    return this.repositoryJPA.findById(id).orElseThrow(() -> new RuntimeException("Feedstock not found"));
  }

  public List<FeedstockListOutput> findAll() {
    var useCase = new ListFeedstock(this.repositoryJPA);
    return useCase.exec();
  }
}
