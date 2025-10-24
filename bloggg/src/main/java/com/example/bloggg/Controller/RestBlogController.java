package com.example.bloggg.Controller;

import com.example.bloggg.Entity.Blog;
import com.example.bloggg.Service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;



    @GetMapping("")
    public ResponseEntity<List<Blog>> getAll(){
        List<Blog> blogs=blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> detail(@PathVariable(name = "id") long id){
        Blog blog=blogService.findById(id);
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

}
