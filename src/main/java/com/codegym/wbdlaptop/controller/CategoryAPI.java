package com.codegym.wbdlaptop.controller;

import com.codegym.wbdlaptop.message.response.ResponseMessage;
import com.codegym.wbdlaptop.model.Category;
import com.codegym.wbdlaptop.model.Song;
import com.codegym.wbdlaptop.model.User;
import com.codegym.wbdlaptop.security.service.UserDetailsServiceImpl;
import com.codegym.wbdlaptop.service.Impl.CategoryServiceImpl;
import com.codegym.wbdlaptop.service.Impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class CategoryAPI {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private SongServiceImpl songService;
    @GetMapping("/category")
    public ResponseEntity pageCategory(@PageableDefault(sort = "nameCategory", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Category> categories = categoryService.findAll(pageable);
        if(categories.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(categories,HttpStatus.OK);
    }
    @PostMapping("/category")
    public ResponseEntity createCategory(@Valid @RequestBody Category category){
        if(category.getNameCategory()==null||category.getNameCategory()==""){
            return new ResponseEntity(new ResponseMessage("noname"),HttpStatus.OK);
        }
        if(category.getAvatarCategory()==null||category.getAvatarCategory()==""){
            return new ResponseEntity(new ResponseMessage("noavatar"),HttpStatus.OK);
        }
        if(categoryService.existsByNameCategory(category.getNameCategory())){
            return new ResponseEntity(new ResponseMessage("nocategory"), HttpStatus.OK);
        }
        categoryService.save(category);
        return new ResponseEntity(new ResponseMessage("yes"),HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity getCategoryId(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if(!category.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(category,HttpStatus.OK);
    }
    @GetMapping("/list-category")
    public ResponseEntity getListCategory() {
        List<Category> categories = categoryService.findAllList();
        if(categories.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(categories, HttpStatus.OK);
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if(!category.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        categoryService.delete(id);
        return new ResponseEntity(new ResponseMessage("yes"), HttpStatus.OK);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity updateCategory(@PathVariable Long id, @Valid @RequestBody Category category){
        Optional<Category> category1 = categoryService.findById(id);
        if(!category1.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if(category.getNameCategory()==null||category.getNameCategory()==""){
            return new ResponseEntity(new ResponseMessage("noname"), HttpStatus.OK);
        }
        if(categoryService.existsByNameCategory(category.getNameCategory())){
            return new ResponseEntity(new ResponseMessage("nocategory"),HttpStatus.OK);
        }
        category1.get().setNameCategory(category.getNameCategory());
        category1.get().setAvatarCategory(category.getAvatarCategory());
        category1.get().setCreateBy(category.getCreateBy());
       categoryService.save(category1.get());
       return new ResponseEntity(new ResponseMessage("yes"), HttpStatus.OK);
    }
    @GetMapping("/category-by-user")
    public ResponseEntity pageCategoryByUser(@PageableDefault(sort = "nameCategory", direction = Sort.Direction.ASC)Pageable pageable){
        User user = userDetailsService.getCurrentUser();
        Page<Category> categories = categoryService.findAllByUserId(user.getId(), pageable);
        if(categories.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(categories,HttpStatus.OK);
    }
    @GetMapping("/song-by-category/{id}")
    public ResponseEntity pageSongByCategory(@PathVariable Long id,@PageableDefault(sort = "nameSong", direction = Sort.Direction.ASC)Pageable pageable){
        Optional<Category> category = categoryService.findById(id);
        Page<Song> songPage = songService.findByNameCategoryContaining(category.get().getNameCategory(),pageable);
        if(songPage.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(songPage, HttpStatus.OK);
    }
    @PutMapping("/update-category")
    public ResponseEntity<?> updatePlayList(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(category,HttpStatus.CREATED);
    }

}
