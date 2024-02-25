package me.dmc.neo4jplayground.api.repository;

import me.dmc.neo4jplayground.api.entity.Post;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PostRepository extends Neo4jRepository<Post, UUID> {
}
