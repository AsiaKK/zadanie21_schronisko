package pl.jkk.schronisko.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import pl.jkk.schronisko.model.Animal;

@Repository
public class AnimalRepository {

    private final String ALL_CATEGORIES = "Wszystkie";

    private List<Animal> animals = new ArrayList<>();
    private String description = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem\n" +
            "        aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo\n" +
            "        enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos\n" +
            "        qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet,\n" +
            "        consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam\n" +
            "        quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam,\n" +
            "        nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse\n" +
            "        quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?";

    public AnimalRepository() {

        Animal animal = new Animal("Azor", "Pies", description, "url");
        animals.add(animal);

        animal = new Animal("Klakier", "Kot", description, "url");
        animals.add(animal);

        animal = new Animal("Reksio", "Pies", description, "url");
        animals.add(animal);
    }

    public List<Animal> findByNameAndCategory(String name, String category) {

        List<Animal> filteredAnimals = new ArrayList<>();

        if (!category.equals(ALL_CATEGORIES) && !name.equals("")) {
            for (Animal animal : animals) {
                if (animal.getName().contains(name)
                        && animal.getCategory().contains(category)) {
                    filteredAnimals.add(animal);
                }
            }
        } else if (category.equals(ALL_CATEGORIES) && !name.equals("")) {
            for (Animal animal : animals) {
                if (animal.getName().contains(name)) {
                    filteredAnimals.add(animal);
                }
            }
        } else if (!category.equals(ALL_CATEGORIES) && name.equals("")) {
            for (Animal animal : animals) {
                if (animal.getCategory().contains(category)) {
                    filteredAnimals.add(animal);
                }
            }
        } else {
            filteredAnimals = animals;
        }
        return filteredAnimals;
    }
}