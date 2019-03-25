package pl.jkk.schronisko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jkk.schronisko.model.Animal;
import pl.jkk.schronisko.utils.AnimalUtil;
import pl.jkk.schronisko.utils.CategoryUtil;

import java.util.List;

@Controller
public class HomeController {

    private CategoryUtil categoryUtil;
    private AnimalUtil animalUtil;

    @Autowired
    public HomeController(CategoryUtil categoryUtil, AnimalUtil animalUtil) {
        this.categoryUtil = categoryUtil;
        this.animalUtil = animalUtil;
    }

    @RequestMapping("/")
    public String showHomePage(Model model) {

        List<Animal> animals = animalUtil.findByNameAndCategory(null, null, null);
        List<String> categories = categoryUtil.findAll();

        model.addAttribute("categories", categories);
        model.addAttribute("animals", animals);

        return "home";
    }

    @GetMapping("/azor")
    public String showDogAzor() {
        return "azor";
    }

    @GetMapping("/klakier")
    public String showCatKlakier() {
        return "klakier";
    }

    @GetMapping("/reksio")
    public String showDogReksio() {
        return "reksio";
    }

    @GetMapping("/all")
    public String showAllAnimals() {
        return "all";
    }

    @GetMapping("/cats")
    public String showAllCats() {
        return "cats";
    }

    @GetMapping("/dogs")
    public String showAllDogs() {
        return "dogs";
    }

    @GetMapping("/other")
    public String showOtherAnimal() {
        return "other";
    }

    @GetMapping("/add")
    public String addNewAnimal(Model model) {

        Animal animal = new Animal();
        model.addAttribute("animal", animal);

        List<String> categories = categoryUtil.findAll();
        model.addAttribute("categoriesForm", categories);
        model.addAttribute("addNew", true);

        return "addAnimal";
    }
}