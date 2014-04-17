package org.springframework.social.showcase.neo4j.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import org.springframework.social.showcase.neo4j.domain.Neo4jAccount;

/**
 * @author mh
 * @since 02.04.11
 */
public interface Neo4jAccountRepository extends GraphRepository<Neo4jAccount>,
        RelationshipOperationsRepository<Neo4jAccount> {
    Neo4jAccount findById(String id);
}
