package id.arief.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestClientController {
    @Autowired
    RestTemplate restTemplate;
    

    @GetMapping(value = {"/relami-code"})
    public ResponseEntity<RelamiCode> getRelamiCode(RestTemplate restTemplate) {
        String accessToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkZXZmdW5kZXIwOEBtYWlsaW5hdG9yLmNvbSIsImV4cCI6MTU4NTYyNTkyNiwiaWF0IjoxNTg1NjA3OTI2fQ.heCp269g3wvhfdQ1NGONztpS_ElPt7QwhygmPHfKkLT_21igNfkH4sPP4iOeLqAKhgG9qoJOsyWgN8PiaW4TjQ";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

//        RelamiCode relamiCode = restTemplate.getForObject(
//                "https://api-sandbox.alamisharia.co.id/relami-code", RelamiCode.class);

        ResponseEntity<RelamiCode> response = restTemplate.exchange("https://api-sandbox.alamisharia.co.id/relami-code",
                HttpMethod.GET, new HttpEntity(headers), RelamiCode.class);

        return response;
    }

    @GetMapping(value = {"/employees"})
    public Response getEmployees(RestTemplate restTemplate) {
        Response employees = restTemplate.getForObject(
                "http://dummy.restapiexample.com/api/v1/employees", Response.class);

        return employees;
    }
}
