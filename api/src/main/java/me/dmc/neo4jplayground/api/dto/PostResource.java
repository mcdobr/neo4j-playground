package me.dmc.neo4jplayground.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@RequiredArgsConstructor
@Builder(toBuilder = true)
@Getter
public class PostResource extends RepresentationModel<PostResource> {
//    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private final UUID id;

    @JsonProperty("content")
    private final String content;
}
