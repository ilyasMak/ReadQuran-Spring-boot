package ilyas.yassine.Quran.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Data {
	private int number;
    private String name;
    private String englishName;
    private String englishNameTranslation;
    private String revelationType;
    private int numberOfAyahs;
    private List<Ayah> ayahs ;
    public int getNumberAyahs() {
    	return ayahs.size();
    }
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
	public int getNumberOfAyahs() {
		return numberOfAyahs;
	}
	public void setNumberOfAyahs(int numberOfAyahs) {
		this.numberOfAyahs = numberOfAyahs;
	}
	public List<Ayah> getAyahs() {
		return ayahs;
	}
	public void setAyahs(List<Ayah> ayahs) {
		this.ayahs = ayahs;
	}
	 public String getAyat() {
	    	String ayat ="";
	    	int c = 1 ; 
	    	for (Ayah a : this.ayahs) {
	    		ayat =ayat+ a.getText()+" ﴿"+c+"﴾ ";
	    		c++ ; 
	    	}
	    	System.out.print(ayat);
	    	return ayat;
	    }

	

		
		

}
