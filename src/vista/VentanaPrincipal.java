package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Logica;
import modelo.PersonaVO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtTalla;
	private JTextField txtPeso;
	JLabel etiTitulo;
	JLabel lblDocumento;
	JLabel lblNombre;
	JLabel lblEdad;
	JLabel lblTitulo2;
	JLabel lblTitulo3;
	JLabel lblTalla;
	JLabel lblPeso;
	JTextArea areaTexto;
	JScrollPane scrollArea;
	JLabel etiResultado;
	JButton btnCalcularPromedio;
	JButton btnRegistrar;
	JButton btnListaPersonas;
	Logica miLogica;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		miLogica=new Logica();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 30, 770, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		etiTitulo = new JLabel("Sistema Calculo IMC");
		etiTitulo.setBounds(269, 22, 245, 34);
		etiTitulo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		contentPane.add(etiTitulo);
		
		lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDocumento.setBounds(30, 125, 85, 14);
		contentPane.add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(125, 123, 99, 20);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(238, 125, 66, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(320, 123, 205, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdad.setBounds(535, 125, 51, 14);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(591, 123, 99, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		lblTitulo2 = new JLabel("Datos de la persona:");
		lblTitulo2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo2.setBounds(30, 72, 163, 25);
		contentPane.add(lblTitulo2);
		
		lblTitulo3 = new JLabel("Datos de IMC:");
		lblTitulo3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo3.setBounds(30, 174, 163, 25);
		contentPane.add(lblTitulo3);
		
		lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTalla.setBounds(30, 232, 46, 14);
		contentPane.add(lblTalla);
		
		txtTalla = new JTextField();
		txtTalla.setBounds(84, 230, 86, 20);
		contentPane.add(txtTalla);
		txtTalla.setColumns(10);
		
		lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPeso.setBounds(180, 233, 46, 14);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(238, 230, 86, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		areaTexto = new JTextArea();
		areaTexto.setLineWrap(true);
		areaTexto.setText("");
		
		scrollArea = new JScrollPane();
		scrollArea.setViewportView(areaTexto);
		scrollArea.setBounds(30, 321, 703, 238);
		contentPane.add(scrollArea);
		
		etiResultado = new JLabel("Resultado:");
		etiResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		etiResultado.setBounds(30, 273, 163, 25);
		contentPane.add(etiResultado);
		
		
		btnCalcularPromedio = new JButton("Calcular Promedio");
		btnCalcularPromedio.setBounds(421, 591, 142, 23);
		btnCalcularPromedio.addActionListener(this);
		contentPane.add(btnCalcularPromedio);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(238, 591, 149, 23);
		btnRegistrar.addActionListener(this);
		contentPane.add(btnRegistrar);
		
		btnListaPersonas = new JButton("Lista de personas");
		btnListaPersonas.setBounds(591, 591, 142, 23);
		btnListaPersonas.addActionListener(this);
		contentPane.add(btnListaPersonas);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(btnRegistrar==e.getSource()){
			PersonaVO miPersona=new PersonaVO();
			miPersona.setDocumento(txtDocumento.getText());
			miPersona.setNombre(txtNombre.getText());
			miPersona.setEdad(Integer.parseInt(txtEdad.getText()));
			miPersona.setTalla(Double.parseDouble(txtTalla.getText()));
			miPersona.setPeso(Double.parseDouble(txtPeso.getText()));
			
			
			String dato=miLogica.registrarPersona(miPersona);
			areaTexto.setText(dato);
		}
		
		if(btnListaPersonas==e.getSource()){
			String res=miLogica.consultarListaPersonas();
			areaTexto.setText(res);
		}
		
		if(btnCalcularPromedio==e.getSource()){
			String res=miLogica.consultarPromedio();
			areaTexto.setText(res);
		}
		
	}
}
