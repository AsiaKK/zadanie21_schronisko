package pl.jkk.schronisko.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jkk.schronisko.model.Animal;
import pl.jkk.schronisko.repository.AnimalRepository;

import java.util.Collections;
import java.util.List;

@Service
public class AnimalUtil {

    private final String SORTING_ASC="";
    private final String SORTING_DESC="";
    private final String All_CATEGORY="";
    private final String DEFAULT_NAME="";
    private final String DEFAULT_SORTING_TYPE="";

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalUtil(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> findByNameAndCategory(String name, String category, String sortingType) {

        if (category == null)
            category = All_CATEGORY;

        if (name == null)
            name = DEFAULT_NAME;

        if (sortingType == null)
            sortingType = DEFAULT_SORTING_TYPE;

        List<Animal> animal = animalRepository.findByNameAndCategory(name, category);

        sortList(animal, sortingType);

        return animal;
    }

    private void sortList(List<Animal> animal, String sortingType) {

        if (sortingType.contentEquals(SORTING_ASC))
            Collections.sort(animal);
        else if (sortingType.contentEquals(SORTING_DESC)) {
            Collections.sort(animal);
            Collections.reverse(animal);
        }
    }
}