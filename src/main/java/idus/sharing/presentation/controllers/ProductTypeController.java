package idus.sharing.presentation.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idus.sharing.core.domain.productType.ProductType;
import idus.sharing.infra.services.ProductTypeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("product/type")
@RequiredArgsConstructor
public class ProductTypeController {
  private final ProductTypeService service;

  @GetMapping
  public ResponseEntity<List<ProductType>> findAll() {
    var response = this.service.findAll();
    return ResponseEntity.ok().body(response);
  }
}
