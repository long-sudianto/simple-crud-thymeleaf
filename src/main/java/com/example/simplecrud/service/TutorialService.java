package com.example.simplecrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.simplecrud.model.Tutorial;

@Service
public class TutorialService {
        
	public void printTutorial(){
    	RestTemplate restTemplate = new RestTemplate();
    	
    	String response = restTemplate.getForObject("http://localhost:8080/api/tutorials/1", String.class);
    	System.out.println("http://localhost:8080/api/tutorials/1 : " + response.toString());

    }
    
    
    
    
    
    
    
    
    
    public Tutorial getTutorialsById(){
    	RestTemplate restTemplate = new RestTemplate();
    	
    	Tutorial response = restTemplate.getForObject("http://localhost:8080/api/tutorials/1", Tutorial.class);
    	System.out.println("http://localhost:8080/api/tutorials/1 ke 2 : " + response.toString());    	
    	return response;
    }
    
    
    

    public List<Tutorial> getAllTutorials() {
    	RestTemplate restTemplate = new RestTemplate();
    	List<Tutorial> tutorials = new ArrayList<Tutorial>();
    	
    	//ResponseEntity<List<Tutorial>> response = restTemplate.exchange("http://localhost:8080/api/tutorials/", HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Tutorial>>(){});
        ResponseEntity<Tutorial[]> response = restTemplate.getForEntity("http://localhost:8080/api/tutorials/", Tutorial[].class);
        
        for (int i = 0; i < response.getBody().length ; i++) {
        	tutorials.add(response.getBody()[i]);
		}        
        
    	return tutorials;
    }
    
    
    
    
    public ResponseEntity<Tutorial> postTutorials(Tutorial tutorial){
    	RestTemplate restTemplate = new RestTemplate();
    	Tutorial response = restTemplate.postForObject("http://localhost:8080/api/tutorials/", tutorial, Tutorial.class);
    	return ResponseEntity.ok(response);
    }
    
    
    
//    
//    public User getUserById(Long id) {
//        ResponseEntity<Response<User>> response = restTemplate.exchange(usersApiWithId, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<Response<User>>(){}, id);
//        log.info("getUserById response: "+response.getBody().toString());
//        User user = response.getBody().getPayload();
//        return user;
//    }
//    
//    public User saveUser(User user) {
//        return restTemplate.postForObject(usersApi, user, User.class);
//    }
//
//    public User update(Long id, User user) {
//        return restTemplate.exchange(usersApiWithId, HttpMethod.PUT, new HttpEntity<>(user), User.class, id).getBody();
//    }

}
