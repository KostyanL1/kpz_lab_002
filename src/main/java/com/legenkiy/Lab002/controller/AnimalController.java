package com.legenkiy.Lab002.controller;

import com.legenkiy.Lab002.model.Animal;
import com.legenkiy.Lab002.service.AnimalService;
import com.legenkiy.Lab002.service.CormService;
import com.legenkiy.Lab002.service.VolierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService animalService;
    private final VolierService volierService;
    private final CormService cormService;

    @Autowired
    public AnimalController(AnimalService animalService, VolierService volierService, CormService cormService) {
        this.animalService = animalService;
        this.volierService = volierService;
        this.cormService = cormService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("animals", animalService.getAll());
        return "animal/animalPage";
    }

    @GetMapping("/{id}")
    public String getAnimalPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("animal", animalService.getById(id));
        return "animal/animal";
    }

    @GetMapping("/new")
    public String getNewPage(@ModelAttribute("animal") Animal animal, Model model) {
        model.addAttribute("corms", cormService.getAll());
        model.addAttribute("voliers", volierService.getFreeVoliers());
        return "animal/animalNew";
    }

    @PostMapping()
    public String saveNewAnimal(@ModelAttribute("animal") @Valid Animal animal, @RequestParam("volierId") int volierId,
                                @RequestParam("cormId") int cormId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "animal/animalNew";
        }
        animalService.save(animal, volierId, cormId);
        return "redirect:/animals";
    }

    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable("id") int id) {
        animalService.delete(id);
        return "redirect:/animals";
    }

    @GetMapping("/edit/{id}")
    public String editAnimal(Model model, @PathVariable("id") int id) {
        model.addAttribute("corms", cormService.getCormByCategory(animalService.getById(id).getCategory()));
        model.addAttribute("voliers", volierService.getFreeVoliers());
        model.addAttribute("animal", animalService.getById(id));
        return "animal/animalEdit";
    }

    @PatchMapping("/save/{id}")
    public String saveEdit(@ModelAttribute("animal") @Valid Animal animal, BindingResult bindingResult,
                           @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "animal/animalEdit";
        }
        animalService.edit(animal, id);
        return "redirect:/animals/" + id;
    }
}
