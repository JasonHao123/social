package jason.app.socailcapital.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ProviderUserPK.class)
public class ProviderUser {
    @Id
    private Long userId;
    @Id
    private String providerId;
    @Id
    private String providerUserId;
    
    private String displayName;
    
    private String profileUrl;
    
    private String imageUrl;
    
    private String accessToken;
    
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getProfileUrl() {
        return profileUrl;
    }
    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
   
    public String getProviderId() {
        return providerId;
    }
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
    public String getProviderUserId() {
        return providerUserId;
    }
    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
}
