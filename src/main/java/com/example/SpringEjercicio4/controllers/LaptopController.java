package com.example.SpringEjercicio4.controllers;

import com.example.SpringEjercicio4.repositories.LaptopRepository;
import com.example.SpringEjercicio4.entities.Laptop;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    // 1. Atributos

    LaptopRepository laptoprepository;

    // 2. Constructores

    public LaptopController(LaptopRepository laptoprepository) {
        this.laptoprepository = laptoprepository;
    }

    // @GetMapping("/api/laptops")
    // public List<Laptop> findall(){
    //     return laptoprepository.findAll();
    // }
    //@PostMapping("/api/laptop")
    // public Laptop create(Laptop laptop){
    //return laptoprepository.save(laptop);
    // }

    //Metodos CRUD

    //Find All
    @GetMapping("/api/laptopss")
    public List<Laptop> findAll() {

        return laptoprepository.findAll();
    }

    //FindOneById
    @GetMapping("/api/laptops/{id}")
    public Laptop findoneById(@PathVariable Long id) {
        Optional<Laptop> result = laptoprepository.findById(id);
        if (result.isPresent())
            return result.get();
        else
            return null;
    }

    //Create
    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop) {
        if (laptop.getId() != null) {
            System.out.println("Libro ya existente");
            return null;

        } else {
            return laptoprepository.save(laptop);
        }
    }
    //Update
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() != null){
            return ResponseEntity.ok(laptoprepository.save(laptop));
        }else{
            System.out.println("Cant update a laptop without id");
            return ResponseEntity.badRequest().build();
        }
    }
    //Delete
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        Optional<Laptop> resultd= laptoprepository.findById(id);
        if(resultd.isPresent()){
            laptoprepository.delete(resultd.get());
            return ResponseEntity.noContent().build();
        }else{
            System.out.println("Cant delete a laptop that doesnt exists");
            return ResponseEntity.notFound().build();
        }

    }

    //Delete all
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        System.out.println("deleting");
        laptoprepository.deleteAll();
        return ResponseEntity.noContent().build();
    }



}



