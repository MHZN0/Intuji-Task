package com.example.task1.service;

import com.example.task1.Model.Blog;
import com.example.task1.repo.BlogRepo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogService {

    private final Map<Long, Blog> blogStore = new HashMap<>();
    private long currentId = 1;

    public List<Blog> getAllBlogs() {
        return new ArrayList<>(blogStore.values());
    }

    public Optional<Blog> getBlogById(Long id) {
        return Optional.ofNullable(blogStore.get(id));
    }

    public Blog createBlog(Blog blog) {
        blog.setId(currentId++);
        blogStore.put(blog.getId(), blog);
        return blog;
    }

    public Blog updateBlog(Long id, Blog updatedBlog) {
        if (!blogStore.containsKey(id)) {
            throw new RuntimeException("Blog not found!");
        }
        Blog blog = blogStore.get(id);
        blog.setTitle(updatedBlog.getTitle());
        blog.setDescription(updatedBlog.getDescription());
        blog.setCategory(updatedBlog.getCategory());
        blogStore.put(id, blog);
        return blog;
    }
}
