package pl.jkk.schronisko.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jkk.schronisko.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryUtil {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryUtil(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<String> findAll() {
        return categoryRepository.findAllCategories();
    }
}