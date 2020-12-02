package com.example.demo.service;

import com.example.demo.model.Dish;
import com.example.demo.model.MenuContent;
import com.example.demo.repository.DishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DishService {

    private final DishRepo dishRepo;
    private final MenuContentService menuContentService;

    @Autowired
    public DishService(DishRepo dishRepo, MenuContentService menuContentService) {
        this.dishRepo = dishRepo;
        this.menuContentService = menuContentService;
    }

    public Dish createDish(Dish dish) {
        return dishRepo.save(dish);
    }

    public List<Dish> findAll(){return dishRepo.findAll();}

    public ResponseEntity<List<Dish>> getExtrasForMenu(String menuName) {

        List<MenuContent> fixedDishes = menuContentService.getMenuContentByName(menuName).getBody();
        List<Dish> extras  = findAll();

        //For each dish on the menu (i loop), check if a corresponding dish
        //exists in the list of all dishes (j loop)
        for (int i = 0; i < fixedDishes.size(); ++i) {
            String menuDish = fixedDishes.get(i).getDishName();

            //If this dish exists as part of the fixed menu,
            //remove it for the optional extras and decrement
            //the counter, so no element is skipped
            for(int j = 0; j < extras.size(); ++j) {
                if (extras.get(j).getName().equals(menuDish)) {
                    extras.remove(j);
                    --j;
                }
            }
        }
        return new ResponseEntity<>(extras, HttpStatus.OK);
    }
}
