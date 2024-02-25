package me.dmc.neo4jplayground.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dmc.neo4jplayground.api.dto.PostResource;
import me.dmc.neo4jplayground.api.entity.Post;
import me.dmc.neo4jplayground.api.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostResource> findAll() {
        return postRepository.findAll()
                .stream()
                .map(post -> PostResource.builder()
                        .id(post.getId())
                        .content(post.getContent())
                        .build()
                )
                .toList();
    }

    public PostResource create(PostResource postResource) {
        Post post = Post.builder()
                .content(postResource.getContent())
                .build();
        postRepository.save(post);

        PostResource resource = PostResource.builder()
                .id(post.getId())
                .content(post.getContent())
                .build();
        if (log.isDebugEnabled()) {
            log.debug("Created {}", resource);
        }
        return resource;
    }
}
