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

		if (index < eventos.size()-1) {
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub

		Event e = eventos.get(index);
		index++;
		return e;
	}

	@Override
	public Object previous() {
		// TODO Auto-generated method stub

		Event e = eventos.get(index);
		index--;
		return e;

	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub

		if (index > 0 -1) {
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
		index = eventos.size() - 1;

	}

}
