package com.example.task1withbd.Repo;

import com.example.task1withbd.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog, Long> {
}
