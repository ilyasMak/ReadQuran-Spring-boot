package ilyas.yassine.Quran.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ilyas.yassine.Quran.models.Data;
import ilyas.yassine.Quran.models.Surah;
import ilyas.yassine.Quran.models2.ApiResponse2;
import ilyas.yassine.Quran.models2.Data2;




@Service
public class QuranApiService {
	// private final String apiUrl = "https://api.alquran.cloud/v1/quran/quran-uthmani";
	private final String apiSurahsNameURL="https://api.alquran.cloud/v1/surah"	;
	    private final ObjectMapper objectMapper;

	    private final RestTemplate restTemplate;

	    public QuranApiService(RestTemplate restTemplate) {
	        this.objectMapper = new ObjectMapper();
			this.restTemplate = restTemplate;
	    }
	    
	    public List<Data2> getSurahs() throws IOException {
	        String jsonResponse = restTemplate.getForObject(apiSurahsNameURL, String.class);
	        ApiResponse2 response = objectMapper.readValue(jsonResponse, ApiResponse2.class);

	        List<Data2> Surahs = new ArrayList<>();
	        if (response != null && response.getData() != null) {
	            for (Data2 surah : response.getData()) {
	                Surahs.add(surah);
	            }
	        }

	        return Surahs;
	    }
	    public Data getSurah(int number) throws IOException {
	    	String apiUrl = "https://api.alquran.cloud/v1/surah/"+number ; 

	        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
	        ApiResponse response = objectMapper.readValue(jsonResponse, ApiResponse.class);

	        if ( response != null && response.getData() != null ) {
	          
	          return response.getData();
	         
	        }

	        return null;
	    }
	    public int getNumberOfSurah(String name) throws JsonMappingException, JsonProcessingException {
	    	String jsonResponse = restTemplate.getForObject(apiSurahsNameURL, String.class);
	        ApiResponse2 response = objectMapper.readValue(jsonResponse, ApiResponse2.class);

	        List<Data2> Surahs = new ArrayList<>();
	        if (response != null && response.getData() != null) {
	            for (Data2 surah : response.getData()) {
	            	if (surah.getEnglishName().contains(name)) {
	            		System.out.print("yees");
	            		return surah.getNumber();
	            	}
	            }
	    }
	        return 0 ; 
}}
