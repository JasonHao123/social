package org.springframework.social.showcase.neo4j.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * @author mh
 * @since 04.03.11
 */
@RelationshipEntity(type = "OWN")
public class Own {
    @GraphId Long id;
    @EndNode ProviderAccount providerAccount;
    @StartNode Neo4jAccount account;
    
    PrivacyLevel privacyLevel;

    public Own() {
    }

    public Own(Neo4jAccount account, ProviderAccount providerAccount, PrivacyLevel level) {
        this.account = account;
        this.providerAccount = providerAccount;
        this.privacyLevel = level;
    }

   

    @Override
    public String toString() {
        return String.format("%s acts as %s in %s", account, providerAccount, privacyLevel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Own role = (Own) o;
        if (id == null) return super.equals(o);
        return id.equals(role.id);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : super.hashCode();
    }

}
