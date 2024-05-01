package com.legenkiy.Lab002.controller;

import com.legenkiy.Lab002.model.Corm;
import com.legenkiy.Lab002.model.Volier;
import com.legenkiy.Lab002.service.CormService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/corms")
public class CormController {

    private final CormService cormService;
    @Autowired
    public CormController(CormService cormService) {
        this.cormService = cormService;
    }

    @GetMapping()
    public String getAllCorm(Model model){
        model.addAttribute("corms", cormService.getAll());
        return "corm/cormPage";
    }
    @GetMapping("/{id}")
    public String getCormPage(@PathVariable("id") int id, Model model){
        model.addAttribute("corm", cormService.getById(id));
        return "corm/corm";
    }
    @GetMapping("/new")
    public String newCormPage(@ModelAttribute("corm")Corm corm){
        return "corm/newCorm";
    }
    @PostMapping()
    public String saveNew(@ModelAttribute("corm") @Valid Corm corm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "corm/newCorm";
        }
        cormService.save(corm);
        return "redirect:/corms";
    }
    @DeleteMapping("/{id}")
    public String deleteCorm(@PathVariable("id") int id){
        cormService.delete(id);
        return "redirect:/corms";
    }

}
