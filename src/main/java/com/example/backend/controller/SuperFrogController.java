package com.example.backend.controller;

import com.example.backend.domain.Result;
import com.example.backend.domain.StatusCode;
import com.example.backend.domain.SuperFrog;
import com.example.backend.service.SuperFrogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/superfrogs")
public class SuperFrogController {
    private SuperFrogService service;

    public SuperFrogController(SuperFrogService service) {
        this.service = service;
    }

    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.SUCCESS,"Find All Success", service.findAll());
    }

    @GetMapping("/{superFrogId}")
    public Result findById(@PathVariable Integer superFrogId) {
        return new Result(true, StatusCode.SUCCESS, "Find One Success", service.findById(superFrogId));
    }

    @PostMapping
    public Result save(@RequestBody SuperFrog superFrog) {
        service.save(superFrog);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping("/{superFrogId}")
    public Result update(@PathVariable Integer superFrogId, @RequestBody SuperFrog superFrog) {
        service.update(superFrogId, superFrog);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @DeleteMapping("/{superFrogId}")
    public Result deleteById(@PathVariable Integer superFrogId) {
        service.deleteById(superFrogId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }

    @PutMapping("/{superFrogId}/{appearanceId}")
    public Result assignAppearance(@PathVariable Integer superFrogId, @PathVariable String appearanceId){
        service.assignAppearance(superFrogId, appearanceId);
        return new Result(true, StatusCode.SUCCESS, "Appearance Assignment Success");
    }

}
