package be.yapock.ccf.pl.controllers;

import be.yapock.ccf.bll.DogService;
import be.yapock.ccf.pl.models.Dog.DogCreateForm;
import be.yapock.ccf.pl.models.Dog.DogFullDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dog")
public class DogController {
    private final DogService dogService;
    public DogController(DogService dogService){
        this.dogService = dogService;
    }
    @PostMapping()
    public void create(@RequestBody DogCreateForm form){
        dogService.create(form);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DogFullDTO> getOne(@PathVariable long id){
        return ResponseEntity.ok(DogFullDTO.fromEntity(dogService.getOne(id)));
    }
    @GetMapping()
    public ResponseEntity<List<DogFullDTO>> getAll() {
        return ResponseEntity.ok(dogService.getAll().stream()
                .map(DogFullDTO::fromEntity)
                .collect(Collectors.toList()));
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody DogCreateForm form) {
        dogService.update(id, form);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        dogService.delete(id);
    }
}
