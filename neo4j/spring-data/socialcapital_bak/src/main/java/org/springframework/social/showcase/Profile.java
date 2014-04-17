package org.springframework.social.showcase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Profile {

   private String id;
   private String idstr;
   @JsonProperty("id")
public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
@JsonProperty("idstr")
public String getIdstr() {
    return idstr;
}
public void setIdstr(String idstr) {
    this.idstr = idstr;
}

}
