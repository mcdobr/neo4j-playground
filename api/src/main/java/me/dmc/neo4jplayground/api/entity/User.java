package me.dmc.neo4jplayground.api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Node("Person")
public class User {
    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private UUID id;

    @Property("firstName")
    private String firstName;

    @Property("lastName")
    private String lastName;

    @Relationship(type = "LIKED_BY", direction = Relationship.Direction.INCOMING)
    private List<User> likedBy;
}
