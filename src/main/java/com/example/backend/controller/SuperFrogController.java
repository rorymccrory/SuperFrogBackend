package com.example.backend.controller;

import com.example.backend.domain.Result;
import com.example.backend.domain.StatusCode;
import com.example.backend.domain.SuperFrog;
import com.example.backend.service.SuperFrogService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/superfrogs")
public class SuperFrogController {
    private SuperFrogService service;

    public SuperFrogController(SuperFrogService service) {
        this.service = service;
    }
    @CrossOrigin
    @GetMapping
    public Result findAll(){
        return new Result(true, StatusCode.SUCCESS,"Find All Success", service.findAll());
    }
    @CrossOrigin
    @GetMapping("/{superFrogId}")
    public Result findById(@PathVariable Integer superFrogId) {
        return new Result(true, StatusCode.SUCCESS, "Find One Success", service.findById(superFrogId));
    }
    @CrossOrigin
    @PostMapping
    public Result save(@RequestBody SuperFrog superFrog) {
        service.save(superFrog);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }
    @CrossOrigin
    @PutMapping("/{superFrogId}")
    public Result update(@PathVariable Integer superFrogId, @RequestBody SuperFrog superFrog) {
        service.update(superFrogId, superFrog);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }
    @CrossOrigin
    @DeleteMapping("/{superFrogId}")
    public Result deleteById(@PathVariable Integer superFrogId) {
        service.deleteById(superFrogId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
    @CrossOrigin
    @PutMapping("/{superFrogId}/{appearanceId}")
    public Result assignAppearance(@PathVariable Integer superFrogId, @PathVariable String appearanceId){
        service.assignAppearance(superFrogId, appearanceId);
        return new Result(true, StatusCode.SUCCESS, "Appearance Assignment Success");
    }

}
