package assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class retrievingFileData {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your console command.");
		String command=sc.nextLine();
		String path = command.substring(command.indexOf("-file ")+6, command.indexOf(" -stat"));
		String statistic = command.substring(command.indexOf("-stat ")+6, command.indexOf(" -limit"));
		int limit = Integer.parseInt(command.substring(command.indexOf("-limit ")+7, command.indexOf(" -by")));
		String sortedBy = command.substring(command.indexOf("-by ")+4, command.indexOf(" -display"));
		String toBeDisplayed = command.substring(command.indexOf("-display ")+9);
		
		List<CovidData> covidDatas = new ArrayList<CovidData>();

		List<Country> countries = new ArrayList<Country>();
		
		
		try {
			Files.lines(Paths.get(path)).map(x->x.split(",", -1)).skip(1).filter(x->x[1]!="")
			.forEach(x -> {
			if (!countries.stream().filter(c->c.getCOD().equals(x[0])).findFirst().isPresent())
			countries.add(new Country(x[0], x[2], x[1]));
				try {
					covidDatas.add(new CovidData(tryParseDate(x[3]), tryParseDouble(x[4]), tryParseDouble(x[5]), tryParseDouble(x[6]), tryParseDouble(x[8]), tryParseDouble(x[9]), 
							tryParseDouble(x[10]), tryParseDouble(x[17]), tryParseDouble(x[26]), tryParseDouble(x[27]), tryParseDouble(x[48]), tryParseDouble(x[49]), 
							tryParseDouble(x[51]), new Country(x[0], x[2], x[1])));
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
			});
			
			retrievingData(covidDatas, statistic, limit, sortedBy, toBeDisplayed);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void retrievingData(List<CovidData> testDatas, String stat, int limit, String field, String date) {
		sort(testDatas, field);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		if(stat.equals("min")) {
			switch(date) {
			case "DATE":
				Set<Date> dataSetDate= new HashSet<>();
				testDatas.subList(0, limit).forEach(d->dataSetDate.add(d.getDT()));
				if (dataSetDate.size()==limit) 
				testDatas.subList(0, limit).forEach(d->System.out.println(dateFormat.format(d.getDT())));
				else 
					testDatas.subList(0, limit).forEach(d->System.out.println(dateFormat.format(d.getDT())+"  |  "+d.getCountry().getLOC()));				
			break;
			case "COUNTRY": 
				Set<String> dataSetCountry = new HashSet<>();
				testDatas.subList(0, limit).forEach(d->dataSetCountry.add(d.getCountry().getLOC()));
				if (dataSetCountry.size()==limit)
				testDatas.subList(0, limit).forEach(d->System.out.println(d.getCountry().getLOC()));
				else 
					testDatas.subList(0, limit).forEach(d->System.out.println(d.getCountry().getLOC()+"  |  "+dateFormat.format(d.getDT())));
			break;
			case "CONTINENT": 
				Set<String> dataSetContinent= new HashSet<>();
				testDatas.subList(0, limit).forEach(d->dataSetContinent.add(d.getCountry().getContinent()));
				if (dataSetContinent.size()==limit)
				testDatas.subList(0, limit).forEach(d->System.out.println(d.getCountry().getContinent()));
				else 
					testDatas.subList(0, limit).forEach(d->System.out.println(d.getCountry().getContinent()+"  |  "+d.getCountry().getLOC()+"  |  "+dateFormat.format(d.getDT())));
			break;
		}
		}
		
		else if(stat.equals("max")) {
			switch(date) {
			case "DATE": 
			Set<Date> dataSetDate= new HashSet<>();
			testDatas.subList(testDatas.size()-limit-1, testDatas.size()-1).forEach(d->dataSetDate.add(d.getDT()));
			if (dataSetDate.size()==limit) 
			testDatas.subList(testDatas.size()-limit-1, testDatas.size()-1).forEach(d->System.out.println(dateFormat.format(d.getDT())));
			else 
				testDatas.subList(testDatas.size()-limit-1, testDatas.size()-1).forEach(d->System.out.println(dateFormat.format(d.getDT())+"  |  "+d.getCountry().getLOC()));
			break;
			case "COUNTRY": 
			Set<String> dataSetCountry = new HashSet<>();
			testDatas.subList(testDatas.size()-limit-1, testDatas.size()-1).forEach(d->dataSetCountry.add(d.getCountry().getLOC()));
			if (dataSetCountry.size()==limit)
			testDatas.subList(testDatas.size()-limit-1, testDatas.size()-1).forEach(d->System.out.println(d.getCountry().getLOC()));
			else 
				testDatas.subList(testDatas.size()-limit-1, testDatas.size()-1).forEach(d->System.out.println(d.getCountry().getLOC()+"  |  "+dateFormat.format(d.getDT())));
			break;
			case "CONTINENT": 
			Set<String> dataSetContinent= new HashSet<>();
			testDatas.subList(testDatas.size()-limit-1, testDatas.size()-1).forEach(d->dataSetContinent.add(d.getCountry().getContinent()));
			if (dataSetContinent.size()==limit)
			testDatas.subList(testDatas.size()-limit-1, testDatas.size()-1).forEach(d->System.out.println(d.getCountry().getContinent()));
			else 
				testDatas.subList(testDatas.size()-limit-1, testDatas.size()-1).forEach(d->System.out.println(d.getCountry().getContinent()+"  |  "+d.getCountry().getLOC()+"  |  "+dateFormat.format(d.getDT())));
			break;
		}
		}
		else {
			System.out.println("You entered the wrong stat field");
		}
		
	}
	
	public static void sort(List<CovidData> testDatas, String field) {
		Collections.sort(testDatas, new Comparator<CovidData>(){
			public int compare(CovidData d1, CovidData d2) {
				switch(field) {
			case "NC": return Double.valueOf(d1.getNC()).compareTo(d2.getNC());
			case "NCS": return Double.valueOf(d1.getNCS()).compareTo(d2.getNCS());
			case "ND": return Double.valueOf(d1.getND()).compareTo(d2.getND());
			case "NDS": return Double.valueOf(d1.getNDS()).compareTo(d2.getNDS());
			case "NT": return Double.valueOf(d1.getNT()).compareTo(d2.getNT());
			case "NDPC": return Double.valueOf(d1.getND()/d1.getNC()).compareTo(d2.getND()/d2.getNC());
			default: return 0;
			}
			}
		});
	}
	
	
	public static double tryParseDouble(String s) {
		try {
			return Double.parseDouble(s);
		}
		catch(NumberFormatException ex) {
			return 0;
		}
	}
	
	
	public static Date tryParseDate(String s) throws ParseException {
		
			return new SimpleDateFormat("yyyy-MM-dd").parse(s);
		
		
	}
}
