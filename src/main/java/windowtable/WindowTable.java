package windowtable;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

import domain.Registered;

public class WindowTable extends JFrame {
	private Registered register;
	private JTable tabla;

	public WindowTable(Registered register) {
		super("Apuestas	realizadas	por	" + register.getUsername() + ":");
		this.setBounds(100, 100, 700, 200);
		this.register = register;
		UserAdapter adapt = new UserAdapter(register);
		tabla = new JTable(adapt);
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		// Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(tabla);
		// Agregamos el JScrollPane al contenedor
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

}
