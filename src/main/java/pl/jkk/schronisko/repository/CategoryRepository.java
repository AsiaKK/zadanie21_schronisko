package pl.jkk.schronisko.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    private List<String> categories = new ArrayList<>();

    public CategoryRepository() {
        categories.add("Wszystkie");
        categories.add("Kot");
        categories.add("Pies");
        categories.add("Inne");
    }

    public boolean addCategory(String categoryName) {

        boolean categoryExists = false;

        for (String category : categories) {
            if (category.equals(categoryName)) {
                categoryExists = true;
            }
            if (categoryExists) {
                return false;
            } else {
                categories.add(categoryName);

            }
        }
        return true;
    }

    public List<String> findAllCategories() {
        return categories;
    }
}