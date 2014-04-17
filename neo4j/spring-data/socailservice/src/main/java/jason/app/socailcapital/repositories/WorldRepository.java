package jason.app.socailcapital.repositories;

import jason.app.socailcapital.domain.World;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface WorldRepository extends GraphRepository<World> {}
