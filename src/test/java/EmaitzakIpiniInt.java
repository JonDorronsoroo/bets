import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.junit.BeforeClass;
import org.junit.Test;

import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.*;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Registered;
import domain.Team;
import exceptions.EventFinished;
import exceptions.EventNotFinished;
import exceptions.QuestionAlreadyExist;
import test.businessLogic.TestFacadeImplementation;

public class EmaitzakIpiniInt {
	static BLFacadeImplementation sut;
	static TestFacadeImplementation testBL;

	private Event ev;

	@BeforeClass
	public static void setUpClass() {
		DataAccess da= new DataAccess();

		sut=new BLFacadeImplementation(da);

		testBL= new TestFacadeImplementation();
	}

	@Test
	public void test0() {
		Event ev1 = null;
		try {
			Team t1 = new Team("a");
			Team t2 = new Team("b");
			Date d1 = new Date("08/10/2030");
			ev1 = new Event("ev1", d1, t1, t2);

			Question q1 = new Question("q1", 1.00, ev1);
			
			Quote qu1 = new Quote(1.00, "irabazita", q1);
			
			testBL.addEvent(ev1);
			testBL.addQuestion(q1);
			testBL.addQuote(qu1);
			
			assertThrows(EventNotFinished.class, ()->sut.EmaitzakIpini(ev1));

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			testBL.removeEvent(ev1);
		};
		System.out.println("-------------------------------------------");
	}
	
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
			
			testBL.addEvent(ev1);
			testBL.addQuestion(q1);
			testBL.addQuote(qu1);
			
			assertThrows(EventNotFinished.class, ()->sut.EmaitzakIpini(qu1));

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			testBL.removeEvent(ev1);
		};
		System.out.println("-------------------------------------------");
	}
	
	@Test
	public void test4() {
		Event ev1 = null;
		Registered r1 = null;
		try {
			Team t1 = new Team("a");
			Team t2 = new Team("b");
			Date d1 = new Date("07/10/2022");
			ev1 = new Event("ev1", d1, t1, t2);
			
			Question q1 = new Question("Zein irabazi?", 1.00, ev1);
			
			Quote qu41 = new Quote(2.00, "a", q1);
			Quote qu42 = new Quote(0.00, "b", q1);
			
			r1 = new Registered("Jhon", "password", 1234);
			
			Vector<Quote> quotes = new Vector<Quote>();
			quotes.add(qu41); quotes.add(qu42);
					
			testBL.addEvent(ev1);
			testBL.addSport("futbol", ev1);
			testBL.addQuestion(q1);
			Registered dbR = testBL.addRegistered(r1);
			testBL.addQuote(qu41);
			testBL.addQuote(qu42);
			
			testBL.DiruaSartu(dbR, 100.00, d1, "eur");
			sut.ApustuaEgin(dbR, quotes, 10.00, -1);
			sut.EmaitzakIpini(qu41);
			
			assertTrue(dbR.getDirukop().equals(90.00));

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			testBL.removeEvent(ev1);
			testBL.removeRegistered(r1);
		};
		System.out.println("-------------------------------------------");
	}
	
	@Test
	public void test5() {
		Event ev1 = null;
		Registered r1 = null;
		try {
			Team t1 = new Team("a");
			Team t2 = new Team("b");
			Date d1 = new Date("07/10/2022");
			ev1 = new Event("ev1", d1, t1, t2);

			Question q1 = new Question("Zein irabazi?", 1.00, ev1);
			
			Quote qu51 = new Quote(2.00, "a", q1);
			Quote qu52 = new Quote(0.00, "b", q1);
			
			r1 = new Registered("Jhon", "password", 1234);
			
			Vector<Quote> quotes = new Vector<Quote>();
			quotes.add(qu51); quotes.add(qu52);
					
			testBL.addEvent(ev1);
			testBL.addSport("futbol", ev1);
			testBL.addQuestion(q1);
			Registered dbR = testBL.addRegistered(r1);
			testBL.addQuote(qu51);
			testBL.addQuote(qu52);
			
			//Integer apustuBikoitzaGalarazi
			testBL.DiruaSartu(dbR, 100.00, d1, "eur");
			sut.ApustuaEgin(dbR, quotes, 10.00, -1);
			sut.EmaitzakIpini(qu51);
			
			assertTrue(dbR.getDirukop().equals(110.00));

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			testBL.removeEvent(ev1);
			testBL.removeRegistered(r1);
		};
		System.out.println("-------------------------------------------");
	}

}
