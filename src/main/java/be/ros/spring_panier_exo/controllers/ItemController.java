package be.ros.spring_panier_exo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.ros.spring_panier_exo.models.dtos.ItemDTO;
import be.ros.spring_panier_exo.services.impl.ItemServiceImpl;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    private final ItemServiceImpl itemServiceImpl;

    public ItemController(ItemServiceImpl itemServiceImpl) {
        this.itemServiceImpl = itemServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getall() {
        return ResponseEntity.ok(this.itemServiceImpl.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.itemServiceImpl.getOneById(id));
    }
}
