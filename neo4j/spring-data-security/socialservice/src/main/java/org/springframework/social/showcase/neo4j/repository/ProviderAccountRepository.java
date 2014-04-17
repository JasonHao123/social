package org.springframework.social.showcase.neo4j.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import org.springframework.social.showcase.neo4j.domain.Neo4jAccount;
import org.springframework.social.showcase.neo4j.domain.ProviderAccount;

/**
 * @author mh
 * @since 02.04.11
 */
public interface ProviderAccountRepository extends GraphRepository<ProviderAccount>,
        RelationshipOperationsRepository<ProviderAccount> {
    ProviderAccount findById(String id);
}
