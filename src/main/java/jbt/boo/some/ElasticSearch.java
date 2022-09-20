package jbt.boo.some;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ElasticSearch {
    public static void main(String[] args){

        RestTemplate restTemplate = new RestTemplate();

//        HttpHeaders headers = new HttpHeaders();
//        headers.setBasicAuth("admin", "geoserver");
//        headers.add("Content-Type", "application/json");

//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        JSONObject params = new JSONObject();
//        params.put("name","haha");

//        HttpEntity<JSONObject> entity = new HttpEntity<>(params, headers);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:9200/boo/message/_search", HttpMethod.GET, null, String.class);

        System.out.println(response);

    }
}
