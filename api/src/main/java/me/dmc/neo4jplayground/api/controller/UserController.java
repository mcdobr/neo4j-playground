package me.dmc.neo4jplayground.api.controller;

import me.dmc.neo4jplayground.api.dto.FeedResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserController {
    @GetMapping("/api/users/{user-id}/feed")
    public HttpEntity<FeedResource> getFeed(
            @PathVariable(value = "user-id") Integer userId
    ) {
        FeedResource feed = new FeedResource("abcdefg");
        return new ResponseEntity<>(
                feed.add(linkTo(methodOn(UserController.class).getFeed(userId)).withSelfRel()),
                HttpStatus.OK
        );
    }
}
