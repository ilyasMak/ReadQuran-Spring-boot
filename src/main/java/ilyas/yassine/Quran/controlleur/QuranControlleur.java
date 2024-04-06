package ilyas.yassine.Quran.controlleur;
import org.springframework.ui.Model;
import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ilyas.yassine.Quran.models2.Data2;
import jakarta.annotation.Nullable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;




import ilyas.yassine.Quran.Services.QuranApiService;
import ilyas.yassine.Quran.Services.QuranApiServiceEnglish;


class SearchSurah{
	@Nullable
	private String number ; 
	@Nullable
	private String name ;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
}

@RestController
public class QuranControlleur {
	 private final QuranApiService quranApiService ;
	 private final QuranApiServiceEnglish quranApiServiceEn ;
	    @Autowired
	    public QuranControlleur(QuranApiService quranApiService,QuranApiServiceEnglish quranApiServiceEn) {
	        this.quranApiService = quranApiService;
			this.quranApiServiceEn =  quranApiServiceEn;
	    }
	    @GetMapping("/Quran")
	    public ModelAndView SurahNames(Model model) throws IOException {
	        List<Data2> surahs = quranApiService.getSurahs();
	        model.addAttribute("surahs", surahs);
	        return new ModelAndView("Surahs");
	    }
	    
	  
	  
	    
	    @GetMapping("/Quran/{num}")
	    public ModelAndView Surah(@PathVariable int num,Model model ) throws IOException {
	    	  model.addAttribute("Surah", quranApiService.getSurah(num));
	    	
	        return new ModelAndView("Surah");
	    }
	    @GetMapping("/Quran/{num}/En")
	    public ModelAndView SurahEn(@PathVariable int num,Model model) throws IOException {
	    	  model.addAttribute("Surah", quranApiServiceEn.getSurah(num));
		    	
		        return new ModelAndView("Surah");
	    }
	    
	    
	    @RequestMapping(value = "/Search", method = RequestMethod.POST)
	    public ModelAndView Search(@ModelAttribute("SearchSurah") SearchSurah searchSurah, Model model) throws IOException {
	       String n = searchSurah.getNumber();
	       Integer num ;
	       if(n.isEmpty()) num=0;
	       else num =Integer.parseInt(n);
	        String name = searchSurah.getName();
	        System.out.println("111111111111111111111111111111111111111111111111111111111111111");
	        if (num != null && num >= 1 && num <= 114) {
	        	System.out.println("2222222222222222222222222222222222222222222222222222222222222222222222222222");
	            model.addAttribute("Surah", quranApiService.getSurah(num));
	            return new ModelAndView("Surah");
	        } else if (name != null && !name.isEmpty()) {
	        	System.out.println("333333333333333333333333333333333333333333333333333333333333333333");
	            int num2 = quranApiService.getNumberOfSurah(name);
	            if (num2 != 0) {
	                model.addAttribute("Surah", quranApiService.getSurah(num2));
	                return new ModelAndView("Surah");
	            }
	        }
	        System.out.println("4444444444444444444444444444444444444444444444444444444444444");
	        
	        List<Data2> surahs = quranApiService.getSurahs();
	        model.addAttribute("surahs", surahs);
	        return new ModelAndView("Surahs");

	       
	    }

		
	  

	    

}
