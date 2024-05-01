package com.legenkiy.Lab002.controller;

import com.legenkiy.Lab002.model.Volier;
import com.legenkiy.Lab002.service.VolierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/voliers")
public class VolierController {
    private final VolierService volierService;
    @Autowired
    public VolierController(VolierService volierService) {
        this.volierService = volierService;
    }


    @GetMapping()
    public String getAllVoliers(Model model){
        model.addAttribute("voliers", volierService.getAll());
        return "volier/volierPage";
    }

    @GetMapping("/{id}")
    public String getVolier(@PathVariable("id") int id, Model model){
        model.addAttribute("volier", volierService.getById(id));
        return "volier/volier";
    }
    @GetMapping("/new")
    public String getNewVolier(@ModelAttribute("volier") Volier volier){
        return "volier/newVolier";
    }
    @PostMapping()
    public String saveNewVolier(@ModelAttribute("volier") @Valid Volier volier, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "volier/newVolier";
        }
        volierService.save(volier);
        return "redirect:/voliers";

    }
    @DeleteMapping("/{id}")
    public String deleteVolier(@PathVariable("id") int id){
        volierService.delete(id);
        return "redirect:/voliers";
    }


}
