package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.GameDisk;
import org.example.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GameController {
    @Autowired
    private GameService service;

    public String list(Model model){
        model.addAttribute("games", service.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("game", new GameDisk());
        return "form";
    }
    @GetMapping("/save")
    public String save(@Valid @ModelAttribute("game") GameDisk game, Model model) {
        service.save(game);
        return "redirect:/games";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("game", service.findById(id));
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
            service.deleteById(id);
            return "redirect:/games";
    }
}
