package program.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.model.Category;
import program.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository catRepository;

    public List<Category> getAllCategories() {
        return catRepository.findAll();
    }
}
