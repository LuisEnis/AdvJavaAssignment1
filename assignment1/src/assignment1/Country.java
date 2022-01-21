package assignment1;

import java.util.Collection;

public class Country {
	
	String isoCode; //standing for the iso_code
	String location; //Standing for location(the country name)
	String continent; // This should be done if we also see and decide to keep the list of countries in the continent class as every country is in a continent
	Collection<CovidData> datas;
	
	
	public Collection<CovidData> getDatas() {
		return datas;
	}

	public void setDatas(Collection<CovidData> datas) {
		this.datas = datas;
	}

	public Country() {
		
	}
	
	public Country(String isoCode, String location, String continent) {
		this.isoCode=isoCode;
		this.location=location;
		this.continent=continent;
	}
	
	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCOD() {
		return isoCode;
	}
	public String getLOC() {
		return location;
	}
	public void setLOC(String lOC) {
		location = lOC;
	}
	public void setCOD(String cOD) {
		isoCode = cOD;
	}
	
	

}
