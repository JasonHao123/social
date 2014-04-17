package jason.app.socialcapital.web.model;

public class WebProviderUser {
    private String providerId;
    private WebUser user;
    private String providerUserId;
    public String getProviderId() {
        return providerId;
    }
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
    public WebUser getUser() {
        return user;
    }
    public void setUser(WebUser user) {
        this.user = user;
    }
    public String getProviderUserId() {
        return providerUserId;
    }
    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }
}
