package todo.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import todo.dto.ToDoDto;

import java.net.URI;
import java.net.URISyntaxException;

public class BulkToDoClientAppl {
    public static void main(String[] args) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<String> request = new RequestEntity<String>(HttpMethod.GET, new URI("https://jsonplaceholder.typicode.com/todos"));
        ResponseEntity<ToDoDto[]> response = restTemplate.exchange(request, ToDoDto[].class);

        ToDoDto[] posts = response.getBody();
        for (ToDoDto postDto: posts){
            System.out.println(postDto);
        }
    }
}
