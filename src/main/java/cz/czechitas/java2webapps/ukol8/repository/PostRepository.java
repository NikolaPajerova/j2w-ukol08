package cz.czechitas.java2webapps.ukol8.repository;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findBySlug(String slug, Pageable pageable);

    Pageable stran20 = PageRequest.of(0, 20, Sort.by("published").descending());

    Page<Post> findByPublishedBefore(LocalDate dnes, Pageable strany20);
}
