//import static org.junit.jupiter.api.Assertions.*;
/*
import java.util.Date;

import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;

@RunWith(MockitoJUnitRunner.class)
class gertaerakSortuMockInt {
	DataAccess dataAccess = Mockito.mock(DataAccess.class);
	Event mockedEvent = Mockito.mock(Event.class);

	@InjectMocks
	BLFacade sut = new BLFacadeImplementation(dataAccess);

	@Test
	public void test1() {
		// definir parametros
		String description = null;
		String team1 = null;
		String team2 = null;
		String sportName = null;
		Date data = new Date();

		try {
			description = "a-b";
			team1 = "a";
			team2 = "b";
			sportName = "sport";
			data.setMonth(data.getMonth() + 1);
			data.setHours(0);
			data.setMinutes(0);
			data.setSeconds(0);

			// configure mock

			Mockito.doReturn(true).when(dataAccess).gertaerakSortu(description, data, sportName);

			// testa
			boolean emaitza = sut.gertaerakSortu(description, data, sportName);

			// egiaztapena
			//assertTrue(emaitza);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
*/
