package idus.sharing.presentation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idus.sharing.core.usecases.ports.inputs.CreateProductInput;
import idus.sharing.infra.services.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService service;

  @PostMapping
  public ResponseEntity create(@RequestBody CreateProductInput input) {
    var response = this.service.create(input);
    return ResponseEntity.ok().body(null);
  }
}
