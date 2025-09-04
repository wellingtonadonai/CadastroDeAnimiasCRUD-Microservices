package br.com.ebac.animal_service.controllers;

import br.com.ebac.animal_service.entidades.Animal;
import br.com.ebac.animal_service.repository.AnimalRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private AnimalRepositorio repositorio;

    public AnimalController(AnimalRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping
    private List<Animal> findAll(){
        return repositorio.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal){
        return repositorio.save(animal);

    }
    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted(){
        return repositorio.findNotAdopted();
    }
    @GetMapping("/adopted")
    private List<Animal> finAdopted(){
        return repositorio.findAdopted();
    }
}
