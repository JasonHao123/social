package org.springframework.social.showcase.neo4j.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "HAS_RELATION_WITH")
public class Relationship {
    @GraphId Long id;
    @EndNode ProviderAccount fromAccount;
    @StartNode ProviderAccount toAccount;

    RelationType relationType;
    
    PrivacyLevel privacyLevel;
    
    int rating;
    public Relationship() {
    }
    public Relationship(ProviderAccount fromAccount,ProviderAccount toAccount, RelationType relationType, PrivacyLevel privacyLevel,int rating) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.relationType = relationType;
        this.privacyLevel = privacyLevel;
        this.rating = rating;
    }
}
