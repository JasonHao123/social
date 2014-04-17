package org.neo4j.cineasts.movieimport;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class MovieDbApiClient {

    private final String baseUrl = "https://api.themoviedb.org/";
    private final String apiKey;
    protected final ObjectMapper mapper;

    public MovieDbApiClient(String apiKey) {
        this.apiKey = apiKey;
        mapper = new ObjectMapper();
    }

    public Map getMovie(String id) {
        return loadJsonData(id, buildMovieUrl(id));
    }

    private Map loadJsonData(String id, String url) {
        try {
            HashMap<String,Object> value = mapper.readValue(new URL(url), HashMap.class);
            if (value.isEmpty()) return Collections.singletonMap("not_found",System.currentTimeMillis());
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to get data from " + url, e);
        }
    }
    
    private List<Map> loadJsonDataList(String id, String url) {
        try {
            List value = mapper.readValue(new URL(url), List.class);
           return value;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to get data from " + url, e);
        }
    }

    private String buildMovieUrl(String movieId) {
        return String.format("%s3/movie/%s?api_key=%s", baseUrl, movieId, apiKey);
    }

    public Map getPerson(String id) {
        return loadJsonData(id, buildPersonUrl(id));
    }

    private String buildPersonUrl(String personId) {
        return String.format("%s3/person/%s?api_key=%s", baseUrl,  personId,apiKey);
    }

    public List<Map> getMovieCast(String id) {
        return (List<Map>) loadJsonData(id, buildMovieCastUrl(id)).get("crew");
    }

    private String buildMovieCastUrl(String id) {
        return String.format("%s3/movie/%s/credits?api_key=%s", baseUrl, id, apiKey);
    }
}
