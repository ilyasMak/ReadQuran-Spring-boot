package ilyas.yassine.Quran.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)

public class Surah {
	private int number;
    private String name;
    private String englishName;
    private String englishNameTranslation;
    private String revelationType;
    private List<Ayah> ayahs ;
    
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getEnglishNameTranslation() {
		return englishNameTranslation;
	}
	public void setEnglishNameTranslation(String englishNameTranslation) {
		this.englishNameTranslation = englishNameTranslation;
	}
	public String getRevelationType() {
		return revelationType;
	}
	public void setRevelationType(String revelationType) {
		this.revelationType = revelationType;
	}
	public List<Ayah> getAyahs() {
		return ayahs;
	}
	public void setAyahs(List<Ayah> ayahs) {
		this.ayahs = ayahs;
	} 
    public String getAyat() {
    	String ayat ="";
    	for (Ayah a : this.ayahs) {
    		ayat =ayat+"-"+ a.getText();
    	}
    	System.out.print(ayat);
    	return ayat;
    }

}
