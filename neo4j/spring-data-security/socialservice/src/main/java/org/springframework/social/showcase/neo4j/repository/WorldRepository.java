package org.springframework.social.showcase.neo4j.repository;


import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.social.showcase.neo4j.domain.World;

public interface WorldRepository extends GraphRepository<World> {}
