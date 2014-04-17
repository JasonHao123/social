package org.springframework.social.showcase.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FriendDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Transactional
    public void saveFriend(String userId,String providerId,String friendId,String friendName,String friendUrl,String friendImage) {
       String sql = "insert into friend(userId,providerId,providerUserId,rank,displayName,profileUrl,imageUrl) values('"+userId+"','"+providerId+"','"+friendId+"',0,'"+friendName+"','"+friendUrl+"','"+friendImage+"')";
       
        jdbcTemplate.execute(sql);
    }
}
