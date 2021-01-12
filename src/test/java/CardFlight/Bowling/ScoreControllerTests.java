package CardFlight.Bowling;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import CardFlight.Bowling.Model.Frames;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ScoreControllerTests {

	 @Autowired
	 private TestRestTemplate restTemplate;
	     
	 @LocalServerPort
	 int randomServerPort;	
	
	@Test
	public void addingFrames() throws URISyntaxException {
		Frames frame = new Frames();
		String[] rolls = new String[]{"1","2"};
		frame.setRolls(rolls);
		
		int[] expectedResult = new int[] {3};
		
		final String baseUrl = "http://localhost:"+randomServerPort+"/score";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        
        HttpEntity<Frames> request = new HttpEntity<>(frame, headers);
        
        ResponseEntity<int[]> result = this.restTemplate.postForEntity(uri, request, int[].class);
        
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertArrayEquals(expectedResult, result.getBody());
       
	}
	
	@Test
	public void addingFrames2() throws URISyntaxException {
		Frames frame = new Frames();
		String[] rolls = new String[]{"1","/"};
		frame.setRolls(rolls);
		
		int[] expectedResult = new int[] {3,-2147483638};
		
		final String baseUrl = "http://localhost:"+randomServerPort+"/score";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        
        HttpEntity<Frames> request = new HttpEntity<>(frame, headers);
        
        ResponseEntity<int[]> result = this.restTemplate.postForEntity(uri, request, int[].class);
        
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertArrayEquals(expectedResult, result.getBody());
       
	}
	
	@Test
	public void addingFrames3() throws URISyntaxException {
		Frames frame = new Frames();
		String[] rolls = new String[]{"2","1"};
		frame.setRolls(rolls);
		
		int[] expectedResult = new int[] {3,12,3};
		
		final String baseUrl = "http://localhost:"+randomServerPort+"/score";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        
        HttpEntity<Frames> request = new HttpEntity<>(frame, headers);
        
        ResponseEntity<int[]> result = this.restTemplate.postForEntity(uri, request, int[].class);
        
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertArrayEquals(expectedResult, result.getBody());
       
	}
	
	@Test
	public void addingFrames4() throws URISyntaxException {
		Frames frame = new Frames();
		String[] rolls = new String[] {"X","X"};
		frame.setRolls(rolls);
		
		int[] expectedResult = new int[] {3,12,3,-2147483638};
		
		final String baseUrl = "http://localhost:"+randomServerPort+"/score";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        
        HttpEntity<Frames> request = new HttpEntity<>(frame, headers);
        
        ResponseEntity<int[]> result = this.restTemplate.postForEntity(uri, request, int[].class);
        
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertArrayEquals(expectedResult, result.getBody());
       
	}
	@Test
	public void addingFrames5() throws URISyntaxException {
		Frames frame = new Frames();
		String[] rolls = new String[] {"X","X"};
		frame.setRolls(rolls);
		
		int[] expectedResult = new int[] {3,12,3,-2147483638,-2147483638};
		
		final String baseUrl = "http://localhost:"+randomServerPort+"/score";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        
        HttpEntity<Frames> request = new HttpEntity<>(frame, headers);
        
        ResponseEntity<int[]> result = this.restTemplate.postForEntity(uri, request, int[].class);
        
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertArrayEquals(expectedResult, result.getBody());
       
	}
	@Test
	public void addingFrames6() throws URISyntaxException {
		Frames frame = new Frames();
		String[] rolls = new String[] {"1","1"};
		frame.setRolls(rolls);
		
		int[] expectedResult = new int[] {3,12,3,21,12,2};
		
		final String baseUrl = "http://localhost:"+randomServerPort+"/score";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        
        HttpEntity<Frames> request = new HttpEntity<>(frame, headers);
        
        ResponseEntity<int[]> result = this.restTemplate.postForEntity(uri, request, int[].class);
        
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertArrayEquals(expectedResult, result.getBody());
       
	}
}
