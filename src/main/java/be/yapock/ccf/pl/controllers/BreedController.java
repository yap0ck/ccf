package be.yapock.ccf.pl.controllers;

import be.yapock.ccf.bll.BreedService;
import be.yapock.ccf.pl.models.Breed.BreedCreateForm;
import be.yapock.ccf.pl.models.Breed.BreedDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/breed")
public class BreedController {
    private final BreedService breedService;

    public BreedController(BreedService breedService){
        this.breedService = breedService;
    }

    @PostMapping()
    public void create(@RequestBody BreedCreateForm form){
        breedService.create(form);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BreedDTO> getOne(@PathVariable long id){
        return ResponseEntity.ok(BreedDTO.fromEntity(breedService.getBreedById(id)));
    }

    @GetMapping()
    public ResponseEntity<List<BreedDTO>> getAll() {
        return ResponseEntity.ok(breedService.getAllBreeds().stream()
                .map(BreedDTO::fromEntity)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        breedService.delete(id);
    }
}
