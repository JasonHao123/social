package org.springframework.social.showcase.weibo;

import java.util.List;

public class WeiboImportForm {

    private List<String> friends;

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}
