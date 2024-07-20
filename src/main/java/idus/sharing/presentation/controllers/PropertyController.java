package idus.sharing.presentation.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idus.sharing.core.domain.property.Property;
import idus.sharing.infra.services.PropertyService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("product/property")
@AllArgsConstructor
public class PropertyController {
  private final PropertyService service;

  @GetMapping
  public ResponseEntity<List<Property>> findAll() {
    var response = this.service.findAll();

    return ResponseEntity.ok().body(response);
  }
}
