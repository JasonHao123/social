package jason.app.socialcapital.socialservice.repositories;

import jason.app.socialcapital.socialcommon.domain.World;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;

public interface WorldRepository extends GraphRepository<World>,
RelationshipOperationsRepository<World> {}
