package be.yapock.ccf.pl.controllers;

import be.yapock.ccf.bll.DogService;
import be.yapock.ccf.pl.models.Dog.DogCreateForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
