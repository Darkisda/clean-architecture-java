package idus.sharing.presentation.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idus.sharing.core.domain.feedstock.Feedstock;
import idus.sharing.infra.services.FeedstockService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("feedstock")
@RequiredArgsConstructor
public class FeedstockController {
  private final FeedstockService service;

  @GetMapping
  public ResponseEntity<List<Feedstock>> findAll() {
    var response = this.service.findAll();
    return ResponseEntity.ok().body(response);
  }
}
