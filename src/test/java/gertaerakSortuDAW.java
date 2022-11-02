
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import configuration.ConfigXML;
import dataAccess.*;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.Team;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;
import test.businessLogic.TestFacadeImplementation;
import test.dataAccess.TestDataAccess;

public class gertaerakSortuDAW {

	// sut:system under test
	static DataAccess sut = new DataAccess();

	// additional operations needed to execute the test
	static TestDataAccess testDA = new TestDataAccess();

	private Event ev;

	@Test
	// kaxa txuriko lehenengo proba

	public void test1() {
		System.out.println("hola!");
		String sport = "kdfjsñd";
		String description = "owiejweo wedwe  wr we";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate = null;
		;
		try {
			oneDate = sdf.parse("05/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean a = sut.gertaerakSortu(description, oneDate, sport);

		assertEquals(a, false);

	}

	@Test
	// kaxa txurko 3. proba: sut-ari deia egiterakoan "a-b" deskripzioa duen
	// gertaera sortu dugula eta, gertaera berri bat sortu
	// da deskripzio horrekin, hortaz metodoak TRUE itzuliko du.
	public void test3() {

		String description = "Zakuto1-Zakuto2";
		Date d = new Date();

		String sportName = "FutBall";
		String team1 = "Zakuto1";
		String team2 = "Zakuto2";

		try {
			testDA.open();
			testDA.addTeam(team1);
			testDA.addTeam(team2);
			testDA.addSport1(sportName);
			testDA.close();

			// metodoa probatu

			boolean emaitza = sut.gertaerakSortu(description, d, sportName);

			assertTrue(emaitza);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			/*
			//DBaren aurreko egoera berreskuratu
			
			testDA.open();
			testDA.removedSport(sportName);
			testDA.removeTeam(team1);
			testDA.removeTeam(team2);
			testDA.close();
			*/
			

			
			
			// configure the state of the system (create object in the da // configure
			// the state of the system (create object in the dabatase)

		}



	}
	

}


