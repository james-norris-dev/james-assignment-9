package com.coderscampus.recipe.repository;

import com.coderscampus.recipe.domain.Recipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    private final List<Recipe> recipeStorage = new ArrayList<>();

    @Override
    public void saveRecipes(List<Recipe> recipes) {
        recipeStorage.clear();
        recipeStorage.addAll(recipes);
    }

    @Override
    public List<Recipe> findAllRecipes() {
        return new ArrayList<>(recipeStorage);
    }

    @Override
    public List<Recipe> findRecipesBy(Predicate<Recipe> filter) {
        return recipeStorage.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}
