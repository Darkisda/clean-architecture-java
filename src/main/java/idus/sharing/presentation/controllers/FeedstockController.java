package idus.sharing.presentation.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idus.sharing.core.domain.feedstock.Feedstock;
import idus.sharing.core.usecases.ports.outputs.FeedstockListOutput;
import idus.sharing.infra.services.FeedstockService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("feedstock")
@RequiredArgsConstructor
public class FeedstockController {
  private final FeedstockService service;

  @GetMapping("{id}")
  public ResponseEntity<Feedstock> findById(@PathVariable("id") int id) {
    var response = this.service.findById(id);
    return ResponseEntity.ok().body(response);
  }

  @GetMapping
  public ResponseEntity<List<FeedstockListOutput>> findAll() {
    var response = this.service.findAll();
    return ResponseEntity.ok().body(response);
  }
}
