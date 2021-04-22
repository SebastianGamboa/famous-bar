package com.sgb.famousbar.controllers;

import com.sgb.famousbar.services.StackService;
import com.sgb.famousbar.shared.ResponseArray;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class StackController {
    
    StackService stackService;

    public StackController(StackService stackService) {
        this.stackService = stackService;
    }

    @GetMapping("stack/{iterations}/{stackId}")
    public ResponseArray generateArray(@PathVariable int iterations, @PathVariable int stackId) {
        if (iterations <= 0 || stackId <= 0)
            throw new RuntimeException("The parameter(s) has an invalid value");
        return stackService.generateArray(iterations, stackId);
    }
}
