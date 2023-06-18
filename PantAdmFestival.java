import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class PantAdmFestival extends JFrame {
    private GestorFestival gestor;

    private JLabel anoEdicionLbl; // etiqueta ano
    private JTextField anoEdicionTxt; // campo ano

    private JLabel fechaInicioLbl; // etiqueta fecha
    private JSpinner fechaInicio; // spinner de fecha

    private JLabel nombreLbl; // etiqueta nombre
    private JTextField nombreTxt; // campo nombre

    private JButton confirmarBtn; // boton confirmar (capturara datos)

    public void iniciarComponentes() {
        this.anoEdicionLbl = new JLabel("Año de edición:");
        this.anoEdicionTxt = new JTextField(10); // 10 caracteres como long max

        this.nombreLbl = new JLabel("Nombre del festival:");
        this.nombreTxt = new JTextField(20); // 20 caracteres como long max

        this.fechaInicioLbl = new JLabel("Fecha de inicio:");
        this.fechaInicio = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(this.fechaInicio, "dd/MM/yyyy"); // formato
        this.fechaInicio.setEditor(dateEditor);

        this.confirmarBtn = new JButton("Capturar"); // button
    }

    public void configurarDiseno() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // accion por defecto del boton cerrar
        setTitle("Formulario de Datos"); // titulo

        JPanel panel = new JPanel();
        // revisar de haber importado java.awt.*
        panel.setLayout(new GridLayout(4, 2, 10, 10)); // disposicion de elementos

        // agregamos los componentes a la pantalla
        panel.add(anoEdicionLbl);
        panel.add(anoEdicionTxt);
        panel.add(nombreLbl);
        panel.add(nombreTxt);
        panel.add(fechaInicioLbl);
        panel.add(fechaInicio);
        panel.add(confirmarBtn);

        add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null); // centrar en la pantalla
    }

    public void pedirDatosFestival() {
        confirmarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // el atributo "e" de tipo ActionEvent hace de escucha a eventos
                int anio = Integer.parseInt(tomarAnoEdicion()); // obtenemos como string el ano y lo parseamos
                String festival = tomarNombre(); // obtenemos el nombre del festival
                LocalDate fechaInicio = tomarFechaInicio(); // obtenemos la fecha de inicio

                gestor.tomarDatosIdentFestival(anio, festival, fechaInicio);
            }
        });
    }

    public PantAdmFestival(GestorFestival gestor) {
        this.gestor = gestor;

        iniciarComponentes();
        configurarDiseno();
    }

    public void opcionRegFestival() {
        this.habilitarVentana();
    }

    public void habilitarVentana() {
        // logica para hacer visible la ventana
        this.setVisible(true);
        this.gestor.nuevoFestival();
    }

    public String tomarAnoEdicion() {
        // logica de tomar el ano de edicion
        return anoEdicionTxt.getText(); // obtenemos el texto del año (deberia agregarse una validacion que sean solo numeros)
    }

    public String tomarNombre() {
        // logica de tomar la fecha de inicio
        return nombreTxt.getText(); // obtenemos el texto del nombre
    }

    public LocalDate tomarFechaInicio() {
        // logica de tomar el nombre del festival
        Date fecha = (Date) fechaInicio.getValue(); // obtenemos el valor del selector de fecha
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // formateo de la fecha a LocalDate
        return localDate;
    }
}
