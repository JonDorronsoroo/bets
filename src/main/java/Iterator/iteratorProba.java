package Iterator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Factoria.BLFacadeFactory;
import businessLogic.BLFacade;
import configuration.ConfigXML;
import configuration.UtilDate;
import domain.Event;

public class iteratorProba{

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();

		int month=today.get(Calendar.MONTH);
		month+=1;
		int year=today.get(Calendar.YEAR);
		if (month==12) { month=0; year+=1;}  

		ConfigXML c = ConfigXML.getInstance();
		boolean isLocal =	c.isBusinessLogicLocal();
		BLFacadeFactory fakotori = new BLFacadeFactory(c);
		BLFacade blFacade = fakotori.createBLFacade();
		SimpleDateFormat	sdf =	new SimpleDateFormat("dd/MM/yyyy");
		Date date; 
		try {

			date =	UtilDate.newDate(year,month,17);//	17	del	mes	que	viene
			ExtendedIterator i = blFacade.getEventsIterator(date);
			Event	e;
			System.out.println("_____________________");
			System.out.println("RECORRIDO	HACIA	ATRÁS");
			i.goLast();	//	Hacia atrás
			while (i.hasPrevious())	{
				e =	(Event) i.previous();
				System.out.println(e.toString());
			}
			System.out.println();
			System.out.println("_____________________");
			System.out.println("RECORRIDO	HACIA	ADELANTE");
			i.goFirst();	//	Hacia adelante
			while (i.hasNext())	{
				e =	(Event) i.next();
				System.out.println(e.toString());
			}
		}	catch (Exception	e1)	{
			System.out.println("Problems	with	date??	" +	"17/12/2020");

		}
	}
}


