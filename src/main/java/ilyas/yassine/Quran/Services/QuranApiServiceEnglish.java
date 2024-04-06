package ilyas.yassine.Quran.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.fasterxml.jackson.databind.ObjectMapper;

import ilyas.yassine.Quran.models.Data;
import ilyas.yassine.Quran.models.Surah;
import ilyas.yassine.Quran.models2.ApiResponse2;
import ilyas.yassine.Quran.models2.Data2;



@Service
public class QuranApiServiceEnglish {
	private final String apiSurahsNameURL="https://api.alquran.cloud/v1/surah"	;
    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate;

    public QuranApiServiceEnglish(RestTemplate restTemplate) {
        this.objectMapper = new ObjectMapper();
		this.restTemplate = restTemplate;
    }
    
  
    public Data getSurah(int number) throws IOException {
    	String apiUrl = "https://api.alquran.cloud/v1/surah/"+number+"/en.asad";; 
    	
    	System.out.print(apiUrl);
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        ApiResponse response = objectMapper.readValue(jsonResponse, ApiResponse.class);

        if ( response != null && response.getData() != null ) {
          
          return response.getData();
         
        }

        return null;
    }
}
