import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.junit.Test;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.Quote;
import domain.Registered;
import domain.Team;
import exceptions.EventFinished;
import exceptions.EventNotFinished;
import exceptions.QuestionAlreadyExist;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmaitzakIpiniMockInt {
	DataAccess dataAccess=Mockito.mock(DataAccess.class);
	Event mockedEvent=Mockito.mock(Event.class);

	@InjectMocks
	BLFacade sut=new BLFacadeImplementation(dataAccess);

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
			
			Mockito.doReturn(new Exception()).when(dataAccess).EmaitzakIpini(Mockito.any(Quote.class));
			
			sut.EmaitzakIpini(qu1);
			
			ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
			Mockito.verify(dataAccess, Mockito.times(1)).EmaitzakIpini(eventCaptor.capture());
			
			assertEquals(eventCaptor.getValue(), ev1);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
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
			
			Mockito.doReturn(new Exception()).when(dataAccess).EmaitzakIpini(Mockito.any(Quote.class));
			
			sut.EmaitzakIpini(qu1);
			
			ArgumentCaptor<Quote> eventCaptor = ArgumentCaptor.forClass(Quote.class);
			Mockito.verify(dataAccess, Mockito.times(1)).EmaitzakIpini(eventCaptor.capture());
			
			assertEquals(eventCaptor.getValue(), qu1);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
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
			
			Mockito.doReturn(new Exception()).when(dataAccess).EmaitzakIpini(Mockito.any(Quote.class));
			
			sut.EmaitzakIpini(qu41);
			
			ArgumentCaptor<Quote> eventCaptor = ArgumentCaptor.forClass(Quote.class);
			Mockito.verify(dataAccess, Mockito.times(1)).EmaitzakIpini(eventCaptor.capture());
			
			assertEquals(eventCaptor.getValue(), qu41);
			
			

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
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
					
			Mockito.doReturn(new Exception()).when(dataAccess).EmaitzakIpini(Mockito.any(Quote.class));
			
			sut.EmaitzakIpini(qu51);
			
			ArgumentCaptor<Quote> eventCaptor = ArgumentCaptor.forClass(Quote.class);
			Mockito.verify(dataAccess, Mockito.times(1)).EmaitzakIpini(eventCaptor.capture());
			
			assertEquals(eventCaptor.getValue(), qu51);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-------------------------------------------");
	}

}
