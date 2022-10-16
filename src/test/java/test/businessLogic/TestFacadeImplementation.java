package test.businessLogic;


import java.util.Date;

import configuration.ConfigXML;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Registered;
import domain.Sport;
import test.dataAccess.TestDataAccess;

public class TestFacadeImplementation {
	TestDataAccess dbManagerTest;


	public TestFacadeImplementation()  {

		System.out.println("Creating TestFacadeImplementation instance");
		ConfigXML c=ConfigXML.getInstance();
		dbManagerTest=new TestDataAccess(); 
		dbManagerTest.close();
	}


	public boolean removeEvent(Event ev) {
		dbManagerTest.open();
		boolean b=dbManagerTest.removeEvent(ev);
		dbManagerTest.close();
		return b;

	}

	public Event addEventWithQuestion(String desc, Date d, String q, float qty) {
		dbManagerTest.open();
		Event o=dbManagerTest.addEventWithQuestion(desc,d,q, qty);
		dbManagerTest.close();
		return o;

	}

	public void addEvent(Event event) {
		dbManagerTest.open();
		dbManagerTest.addEvent(event);
		dbManagerTest.close();
	}

	public void addQuote(Quote quote) {
		dbManagerTest.open();
		dbManagerTest.addQuote(quote);
		dbManagerTest.close();
	}

	public void addQuestion(Question question) {
		dbManagerTest.open();
		dbManagerTest.addQuestion(question);
		dbManagerTest.close();
	}

	public void addSport(String sport, Event ev) {
		dbManagerTest.open();
		dbManagerTest.addSport(sport, ev);
		dbManagerTest.close();
	}
	
	public void addSport1(String sport) {
		dbManagerTest.open();
		dbManagerTest.addSport1(sport);
		dbManagerTest.close();
	}
	
	public void addTeam(String team) {
		dbManagerTest.open();
		dbManagerTest.addTeam(team);
		dbManagerTest.close();
	}

	public Registered addRegistered(Registered r) {
		dbManagerTest.open();
		Registered a = dbManagerTest.addRegistered(r);
		dbManagerTest.close();
		return(a);
	}

	public boolean removeRegistered(Registered r) {
		dbManagerTest.open();
		Boolean a = dbManagerTest.removeRegistered(r);
		dbManagerTest.close();
		return(a);
	}

	public void DiruaSartu(Registered r, double d, Date date, String s) {
		dbManagerTest.open();
		dbManagerTest.DiruaSartu(r, d, date, s);
		dbManagerTest.close();

	}
	
	public void removeSport(String sport) {
		dbManagerTest.open();
		dbManagerTest.removedSport1(sport);
		dbManagerTest.close();
	}

	public void removeTeam(String team) {
		dbManagerTest.open();
		dbManagerTest.removeTeam1(team);
		dbManagerTest.close();
	}
	
}
