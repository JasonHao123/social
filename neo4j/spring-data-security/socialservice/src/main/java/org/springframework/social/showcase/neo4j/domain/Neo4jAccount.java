package org.springframework.social.showcase.neo4j.domain;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.support.index.IndexType;

/**
 * @author mh
 * @since 12.03.11
 */
@NodeEntity
public class Neo4jAccount {
    @GraphId Long nodeId;
    @Indexed(unique=true)
    String id;
    @Indexed(indexType=IndexType.FULLTEXT, indexName = "people")
    String name;
    private Date birthday;
    private String birthplace;
    private String biography;
    private Integer version;
    private Date lastModified;
    private String profileImageUrl;
    
    
    @RelatedToVia
    Collection<Own> accounts;

    public Neo4jAccount(String id, String name) {
        this.id = id;
        this.name = name;
    }

    protected Neo4jAccount() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", name, id);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getBiography() {
        return biography;
    }

    public Integer getVersion() {
        return version;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Neo4jAccount person = (Neo4jAccount) o;
        if (nodeId == null) return super.equals(o);
        return nodeId.equals(person.nodeId);

    }

    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : super.hashCode();
    }

    public Own own(ProviderAccount providerAccount, PrivacyLevel privacyLevel) {
        final Own account = new Own(this, providerAccount, privacyLevel);
        accounts.add(account);
        return account;
    }

}
