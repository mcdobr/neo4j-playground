package me.dmc.neo4jplayground.api.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@RequiredArgsConstructor
@Getter
public class FeedResource extends RepresentationModel<FeedResource> {
    private final String content;
}
