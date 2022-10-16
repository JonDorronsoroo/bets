import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import configuration.ConfigXML;
import dataAccess.*;
import dataAccess.DataAccess;
import domain.ApustuAnitza;
import domain.Apustua;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Registered;
import domain.Sport;
import domain.Team;
import exceptions.EventFinished;
import exceptions.EventNotFinished;
import exceptions.QuestionAlreadyExist;
import test.businessLogic.TestFacadeImplementation;
import test.dataAccess.TestDataAccess;

public class EmaitzakIpiniDAW {

	//sut:system under test
	static DataAccess sut=new DataAccess();

	//additional operations needed to execute the test 
	static TestDataAccess testDA=new TestDataAccess();
	
	@Test
	public void test1() {
		Event ev1 = null;
		try {
			Team t1 = new Team("a");
			Team t2 = new Team("b");
			Date d1 = new Date("08/10/2030");
			ev1 = new Event("ev1", d1, t1, t2);

			Question q1 = new Question("q1", 1.00, ev1);
			
			Quote qu1 = new Quote(1.00, "irabazita", q1);
			
			testDA.open();
			testDA.addEvent(ev1);
			testDA.addQuestion(q1);
			testDA.addQuote(qu1);
			testDA.close();
			
			assertThrows(EventNotFinished.class, ()->sut.EmaitzakIpini(qu1));

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			testDA.open();
			testDA.removeEvent(ev1);
			testDA.close();
		};
		System.out.println("-------------------------------------------");
	}
	
	@Test
	public void test2() {
		Event ev1 = null;
		try {
			Team t1 = new Team("a");
			Team t2 = new Team("b");
			Date d1 = new Date("07/10/2022");
			ev1 = new Event("ev1", d1, t1, t2);

			Question q1 = new Question("q1", 1.00, ev1);
			
			Quote qu2 = new Quote(1.00, "irabazita", q1);
			
			testDA.open();
			testDA.addEvent(ev1);
			testDA.addQuote(qu2);
			testDA.close();
			
			sut.EmaitzakIpini(qu2);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			testDA.open();
			testDA.removeEvent(ev1);
			testDA.close();
		};
		System.out.println("-------------------------------------------");
	}
	
	@Test
	public void test3() {
		Event ev1 = null;
		try {
			Team t1 = new Team("a");
			Team t2 = new Team("b");
			Date d1 = new Date("07/10/2022");
			ev1 = new Event("ev1", d1, t1, t2);

			Question q1 = new Question("q1", 1.00, ev1);
			
			Quote qu3 = new Quote(1.00, "irabazita", q1);
			
			testDA.open();
			testDA.addEvent(ev1);
			testDA.addQuestion(q1);
			testDA.addQuote(qu3);
			testDA.close();
			
			sut.EmaitzakIpini(qu3);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			testDA.open();
			testDA.removeEvent(ev1);
			testDA.close();
		};
		System.out.println("-------------------------------------------");
	}
	
	@Test
	public void test4() {
		Event ev1 = null;
		Registered r2 = null;
		Sport s = null;
		try {
			Team t1 = new Team("a");
			Team t2 = new Team("b");
			Date d1 = new Date("07/10/2022");
			ev1 = new Event("ev1", d1, t1, t2);
			Question q1 = new Question("Zein irabazi?", 1.00, ev1);
			Quote qu41 = new Quote(2.00, "a", q1);
			Quote qu42 = new Quote(0.00, "b", q1);
			r2 = new Registered("Jhon", "password", 1234);
			Vector<Quote> quotes = new Vector<Quote>();
			quotes.add(qu41); quotes.add(qu42);
					
			testDA.open();
			testDA.addEvent(ev1);
			s = testDA.addSport("futbol", ev1);
			testDA.addQuestion(q1);
			Registered dbR = testDA.addRegistered(r2);
			testDA.addQuote(qu41);
			testDA.addQuote(qu42);
			testDA.close();
			
			sut.DiruaSartu(dbR, 100.00, d1, "eur");
			sut.ApustuaEgin(dbR, quotes, 10.00, -1);
			sut.EmaitzakIpini(qu41);
			
			assertTrue(dbR.getDirukop().equals(90.00));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			testDA.open();
			testDA.removeEvent(ev1);
			testDA.removeRegistered(r2);
			testDA.removeSport(s);
			testDA.close();
		};
		System.out.println("-------------------------------------------");
	}
	
	@Test
	public void test5() {
		Event ev1 = null;
		Registered r3 = null;
		Sport s = null;
		try {
			Team t1 = new Team("a");
			Team t2 = new Team("b");
			Date d1 = new Date("07/10/2022");
			ev1 = new Event("ev1", d1, t1, t2);
			Question q1 = new Question("Zein irabazi?", 1.00, ev1);
			Quote qu51 = new Quote(2.00, "a", q1);
			Quote qu52 = new Quote(0.00, "b", q1);
			r3 = new Registered("Jhon", "password", 1234);
			Vector<Quote> quotes = new Vector<Quote>();
			quotes.add(qu51); quotes.add(qu52);
					
			testDA.open();
			testDA.addEvent(ev1);
			s = testDA.addSport("futbol", ev1);
			testDA.addQuestion(q1);
			Registered dbR = testDA.addRegistered(r3);
			testDA.addQuote(qu51);
			testDA.addQuote(qu52);
			testDA.close();
		
			sut.DiruaSartu(dbR, 100.00, d1, "eur");
			sut.ApustuaEgin(dbR, quotes, 10.00, -1);
			sut.EmaitzakIpini(qu51);
			
			assertTrue(dbR.getDirukop().equals(110.00));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			testDA.open();
			testDA.removeEvent(ev1);
			testDA.removeRegistered(r3);
			testDA.removeSport(s);
			testDA.close();
		};
		System.out.println("-------------------------------------------");
	}
	
	@Test
	public void test6() {
		Event ev1 = null;
		Registered r4 = null;
		Sport s = null;
		try {
			Team t1 = new Team("a");
			Team t2 = new Team("b");
			Date d1 = new Date("07/10/2022");
			ev1 = new Event("ev1", d1, t1, t2);
			Question q1 = new Question("Zein irabazi?", 1.00, ev1);
			Quote qu61 = new Quote(2.00, "a", q1);
			Quote qu62 = new Quote(0.00, "b", q1);
			r4 = new Registered("Jhon", "password", 1234);
			Vector<Quote> quotes = new Vector<Quote>();
			quotes.add(qu61); quotes.add(qu62);
					
			testDA.open();
			testDA.addEvent(ev1);
			s = testDA.addSport("futbol", ev1);
			testDA.addQuestion(q1);
			Registered dbR = testDA.addRegistered(r4);
			testDA.addQuote(qu61);
			testDA.addQuote(qu62);
			testDA.close();
			
			sut.DiruaSartu(dbR, 100.00, d1, "eur");
			sut.ApustuaEgin(dbR, quotes, 10.00, -1);
			sut.ApustuaEgin(dbR, quotes, 10.00, -1);
			sut.EmaitzakIpini(qu61);
			assertTrue(dbR.getDirukop().equals(120.00));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			testDA.open();
			testDA.removeEvent(ev1);
			testDA.removeRegistered(r4);
			testDA.removeSport(s);
			testDA.close();
		};
		System.out.println("-------------------------------------------");
	}
	
	@Test
	public void test7() {
		Event ev1 = null;
		Registered r5 = null;
		Sport s = null;
		try {
			Team t1 = new Team("a");
			Team t2 = new Team("b");
			Date d1 = new Date("07/10/2022");
			ev1 = new Event("ev1", d1, t1, t2);
			Question q1 = new Question("Zein irabazi?", 1.00, ev1);
			Quote qu71 = new Quote(2.00, "a", q1);
			Quote qu72 = new Quote(0.00, "b", q1);
			r5 = new Registered("Jhon", "password", 1234);
			Vector<Quote> quotes = new Vector<Quote>();
			quotes.add(qu71); quotes.add(qu72);
					
			testDA.open();
			testDA.addEvent(ev1);
			s = testDA.addSport("futbol", ev1);
			testDA.addQuestion(q1);
			Registered dbR = testDA.addRegistered(r5);
			testDA.addQuote(qu71);
			testDA.addQuote(qu72);
			testDA.close();
			
			sut.DiruaSartu(dbR, 100.00, d1, "eur");
			sut.ApustuaEgin(dbR, quotes, 10.00, -1);
			sut.ApustuaEgin(dbR, quotes, 10.00, -1);
			sut.EmaitzakIpini(qu71);
			assertTrue(dbR.getDirukop().equals(120.00));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			testDA.open();
			testDA.removeEvent(ev1);
			testDA.removeRegistered(r5);
			testDA.removeSport(s);
			testDA.close();
		};
		System.out.println("-------------------------------------------");
	}
	
}
