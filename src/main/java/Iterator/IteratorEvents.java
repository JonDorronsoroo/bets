package Iterator;

import java.util.ArrayList;
import java.util.Vector;

import domain.Event;

public class IteratorEvents implements ExtendedIterator {
	private Vector<Event> eventos;
	private int index;

	public IteratorEvents(Vector<Event> eventos) {
		this.eventos = eventos;
		index = 0;
	}
	

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		index++;
		if (eventos.get(index) != null) {
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		index++;
		return eventos.get(index);
	}

	@Override
	public Object previous() {
		// TODO Auto-generated method stub
		index--;
		return eventos.get(index);

	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		index--;
		if (eventos.get(index) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void goFirst() {
		// TODO Auto-generated method stub
		index = 0; 

	}

	@Override
	public void goLast() {
		// TODO Auto-generated method stub
		index = eventos.size()-1;
		

		
	}

}
