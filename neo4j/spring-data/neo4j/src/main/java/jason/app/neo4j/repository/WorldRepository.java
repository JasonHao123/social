package jason.app.neo4j.repository;

import jason.app.neo4j.domain.World;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface WorldRepository extends GraphRepository<World> {}
