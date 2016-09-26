package cajero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Agregar extends Entrada {
    
        JTextField pantalla;
	double resultado;
	String operacion;
	JPanel panelNumeros, panelOperaciones;
	boolean nuevaOperacion = true;
        double saldo = 1000;
        double cantidad;
        
	public Agregar() {
		super();
		setSize(400, 400);
		setTitle("Cajero");
                
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(new BorderLayout());
                
		pantalla = new JTextField("0", 20);
		pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
		pantalla.setFont(new Font("Arial", Font.BOLD, 25));
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		pantalla.setEditable(false);
		pantalla.setBackground(Color.WHITE);
		panel.add("North", pantalla);

		panelNumeros = new JPanel();
		panelNumeros.setLayout(new GridLayout(4, 3));
		panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));
                
                
                for (int n = 0; n <= 9; n++) {
			nuevoBotonNumerico("" + n);
		}

		panel.add("Center", panelNumeros);

		panelOperaciones = new JPanel();
		panelOperaciones.setLayout(new GridLayout(8, 3));
		panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

		nuevoBotonOperacion("Agregar");
                nuevoBotonOperacion("Borrar");
                nuevoBotonOperacion("Regresar");
                
                
                     
		panel.add("East", panelOperaciones);

		validate();
	}
        private void nuevoBotonOperacion(String operacion) {
		JButton btn = new JButton(operacion);
                btn.setBackground(Color.pink);
                btn.setForeground(Color.white);
                btn.setFont(new Font("Arial", Font.BOLD, 30));

		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton btn = (JButton) evt.getSource();
				operacionPulsado(btn.getText());
			}
		});
		panelOperaciones.add(btn);
	}
        private void operacionPulsado(String tecla) {
		if (tecla.equals("Consultar")) {
		} else if (tecla.equals("Agregar")) {
                        cantidad = Double.parseDouble(pantalla.getText());
                        dispose();
                        Entrada enters = new Entrada();
                        enters.setVisible(true);
                
		} else if (tecla.equals("Borrar")) {
			resultado = 0;
			pantalla.setText("0");
			nuevaOperacion = true;
		} else if (tecla.equals("Regresar")) {
                        dispose();
			Cajero caj = new Cajero();
                        caj.setVisible(true);
		}
		
        }
        private void nuevoBotonNumerico(String digito) {
		JButton btn = new JButton();
                btn.setBackground(Color.cyan);
                btn.setForeground(Color.white);
                btn.setFont(new Font("Arial", Font.BOLD, 25));
		btn.setText(digito);
		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton btn = (JButton) evt.getSource();
				numeroPulsado(btn.getText());
			}
		});
		panelNumeros.add(btn);
	}
        private void numeroPulsado(String digito) {
		if (pantalla.getText().equals("0") || nuevaOperacion) {
			pantalla.setText(digito);
		} else {
			pantalla.setText(pantalla.getText() + digito);
		}
		nuevaOperacion = false;
	}

  
    double getCantidad() {
        return cantidad;
    }
        
        

}