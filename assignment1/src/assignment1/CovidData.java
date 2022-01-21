package assignment1;

import java.util.Date;

public class CovidData {
	
	Date date;
	double totalCases;
	double newCases;
	double newCasesSmoothed;
	double totalDeaths;
	double newDeaths;
	double newDeathsSmoothed;
	double reproductionRate;
	double newTests;
	double totalTests;
	double stringencyIndex;
	double population;
	double medianAge;
	Country country;
	
	public CovidData(Date dT, double tC, double nC, double nCS, double tD, double nD, double nDS,
			double rR, double nT, double tT, double sI, double pOP, double mA, Country country) {
		date = dT;
		totalCases = tC;
		newCases = nC;
		newCasesSmoothed = nCS;
		totalDeaths = tD;
		newDeaths = nD;
		newDeathsSmoothed = nDS;
		reproductionRate = rR;
		newTests = nT;
		totalTests = tT;
		stringencyIndex = sI;
		population = pOP;
		medianAge = mA;
		this.country=country;
	}
	public Date getDT() {
		return date;
	}
	public double getTC() {
		return totalCases;
	}
	public double getNC() {
		return newCases;
	}
	public double getNCS() {
		return newCasesSmoothed;
	}
	public double getTD() {
		return totalDeaths;
	}
	public double getND() {
		return newDeaths;
	}
	public double getNDS() {
		return newDeathsSmoothed;
	}
	public double getRR() {
		return reproductionRate;
	}
	public double getNT() {
		return newTests;
	}
	public double getTT() {
		return totalTests;
	}
	public double getSI() {
		return stringencyIndex;
	}
	public double getPOP() {
		return population;
	}
	public double getMA() {
		return medianAge;
	}
	public void setDT(Date dT) {
		date = dT;
	}
	public void setTC(double tC) {
		totalCases = tC;
	}
	public void setNC(double nC) {
		newCases = nC;
	}
	public void setNCS(double nCS) {
		newCasesSmoothed = nCS;
	}
	public void setTD(double tD) {
		totalDeaths = tD;
	}
	public void setND(double nD) {
		newDeaths = nD;
	}
	public void setNDS(double nDS) {
		newDeathsSmoothed = nDS;
	}
	public void setRR(double rR) {
		reproductionRate = rR;
	}
	public void setNT(double nT) {
		newTests = nT;
	}
	public void setTT(double tT) {
		totalTests = tT;
	}
	public void setSI(double sI) {
		stringencyIndex = sI;
	}
	public void setPOP(double pOP) {
		population = pOP;
	}
	public void setMA(double mA) {
		medianAge = mA;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
