package com.example.backend.controller;

import com.example.backend.domain.Appearance;
import com.example.backend.domain.Result;
import com.example.backend.domain.StatusCode;
import com.example.backend.service.AppearanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appearances")
public class AppearanceController {

    private AppearanceService appearanceService;

    public AppearanceController(AppearanceService appearanceService) {
        this.appearanceService = appearanceService;
    }

    @GetMapping
    public Result findAll(){
        List<Appearance> all = appearanceService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find All Success", all);
        return result;
    }

    @GetMapping("/{appearanceId}")
    public Result findById(@PathVariable String appearanceId){
        return new Result(true, StatusCode.SUCCESS, "Find One Success", appearanceService.findById(appearanceId));
    }

    @PostMapping
    public Result save(@RequestBody Appearance newAppearance){
        appearanceService.save(newAppearance);
        return new Result(true, StatusCode.SUCCESS, "Create Success");
    }

    @PutMapping("/{appearanceId}")
    public Result update(@PathVariable String appearanceId, @RequestBody Appearance updatedAppearance) {
        appearanceService.update(appearanceId, updatedAppearance);
        return new Result(true, StatusCode.SUCCESS, "Updated Success");
    }

    @DeleteMapping("/{apperaanceId}")
    public Result delete(@PathVariable String appearanceId){
        appearanceService.delete(appearanceId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");

    }
}
