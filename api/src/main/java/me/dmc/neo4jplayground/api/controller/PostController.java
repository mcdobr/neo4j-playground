package me.dmc.neo4jplayground.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dmc.neo4jplayground.api.dto.PostResource;
import me.dmc.neo4jplayground.api.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<PostResource> findAll() {
        List<PostResource> posts = postService.findAll();
        if (log.isDebugEnabled()) {
            log.debug("Found posts: {}", posts);
        }
        return posts;
    }

    @PostMapping
    public PostResource create(@RequestBody PostResource postResource) {
        PostResource post = postService.create(postResource);
        if (log.isDebugEnabled()) {
            log.debug("Created {}", post);
        }
        return post;
    }
}
