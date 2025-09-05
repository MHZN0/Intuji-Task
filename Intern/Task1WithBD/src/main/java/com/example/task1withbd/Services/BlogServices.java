package com.example.task1withbd.Services;

import com.example.task1withbd.Model.Blog;
import com.example.task1withbd.Repo.BlogRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServices {

    private final BlogRepo blogRepo;

    public BlogServices(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    // Get all blogs
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    // Get blog by ID
    public Optional<Blog> getBlogById(Long id) {
        return blogRepo.findById(id);
    }

    // Create blog
    public Blog createBlog(Blog blog) {
        return blogRepo.save(blog);
    }

    // Update blog
    public Optional<Blog> updateBlog(Long id, Blog blogDetails) {
        return blogRepo.findById(id).map(blog -> {
            blog.setTitle(blogDetails.getTitle());
            blog.setDescription(blogDetails.getDescription());
            blog.setCategory(blogDetails.getCategory());
            return blogRepo.save(blog);
        });
    }
}
