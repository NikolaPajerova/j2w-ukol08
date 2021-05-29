package cz.czechitas.java2webapps.ukol8.service;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> list(Pageable strany) {
        return postRepository.findAll(strany);
    }

    public Page<Post> singlePost(String slug, Pageable strany) {
        return postRepository.findOne(slug, strany);
    }
}
