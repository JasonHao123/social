package org.springframework.social.showcase.neo4j.domain;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.support.index.IndexType;

@NodeEntity
public class ProviderAccount {
    @GraphId Long nodeId;
    
    String id;
    
    @RelatedToVia
    Collection<Relationship> relations;
    
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    String provider;
    
    String displayName;
    
    

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }
    
    public Relationship relate(ProviderAccount providerAccount,RelationType relationType, PrivacyLevel privacyLevel,int rate) {
        final Relationship relation = new Relationship(this, providerAccount, relationType,privacyLevel,rate);
        relations.add(relation);
        return relation;
    }
}
