package jbt.boo.some;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class GeoServerRestApi {

    private static final String url = "http://localhost:7777/geoserver/rest/workspaces";

    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) throws ParseException {
//        createWorkSpace();
        getWorkSpace();
    }

    public void method1() {
/*        String res = response.getBody();
        res = res.replaceAll("\\\\","/");

        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody());
            JSONObject res = (JSONObject) jsonObject.get("layers");
            List list = (List) res.get("layer");

            for (Object o : list) {
                System.out.println(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public void method2() throws IOException, URISyntaxException, InterruptedException, ParseException {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "haha");

        HttpClient client = HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("admin", "geoserver".toCharArray());
                    }
                })
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(new ObjectMapper().writeValueAsString(requestBody)))
                .uri(new URI("http://localhost:7777/geoserver/rest/workspaces"))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
    }

    public static void createWorkSpace() {

//        Map<String, String> request = new HashMap<>() {{put("name","haha");}};

        String request =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                    "<workspace>" +
                        "<name>haha</name>" +
                    "</workspace>";

        HttpHeaders headers = new HttpHeaders();
        headers.put("Content-Type", List.of("application/xml"));
        headers.setBasicAuth("admin","geoserver");

        HttpEntity httpEntity = new HttpEntity(request, headers);

        ResponseEntity response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        log.info("response : {}",response);
    }

    public static void getWorkSpace() {

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","geoserver");

        HttpEntity httpEntity = new HttpEntity(headers);

        ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        log.info("response : {}",response);
    }

    public static void createDataStores() {

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","geoserver");

//        String request =
//            "<dataStore>"
//              "<name>" + "boo" + "</name>" +
//              "<connectionParameters>" +
//                "<host>" + "localhost" + "</host>" +
//                "<port>" + "5432" + "</port>" +
//                "<database>" + nyc + "</database>"
//                <user>postgres</user>
//                <passwd>1234</passwd>
//                <dbtype>postgis</dbtype>
//              </connectionParameters>
//            </dataStore>;

        HttpEntity httpEntity = new HttpEntity(headers);

        ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        log.info("response : {}",response);
    }
}
