package org.springframework.social.showcase;

import java.io.File;
import java.io.IOException;

import org.springframework.social.weibo.api.WeiboProfile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

    /**
     * @param args
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonGenerationException 
     */
    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        // TODO Auto-generated method stub
        ObjectMapper mapper = new ObjectMapper();
       
       //   mapper.setPropertyNamingStrategy(new LowerCaseWithUnderscoresStrategy());
       
          File f = new File("test.json");
        
          WeiboProfile bean = (WeiboProfile)mapper.readValue(f, WeiboProfile.class);
       
      
          mapper.writeValue(new File("test1.json"),bean);
        


    }

}
