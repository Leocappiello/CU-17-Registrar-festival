import java.time.LocalDate;
import java.util.ArrayList;

public class GestorFestival {
    private PantAdmFestival pantalla;

    public void nuevoFestival() {
        this.pantalla.pedirDatosFestival();
    }

    public void tomarDatosIdentFestival(int anoEdicion, String nombre, LocalDate fechaInicio) {
        // logica para capturar los datos de los campos
        this.validarFestival(anoEdicion, nombre, fechaInicio);
    }

    public boolean validarFestival(int anoEdicion, String nombre, LocalDate fechaInicio) {
        // Falsa consulta a BBDD que trae un arreglo de datos
        ArrayList<Festival> arrayFestivales = new ArrayList<>(); // arreglo que contendra festivales
        Festival festivalUno = new Festival(2022, "Festival peñas 2022", LocalDate.of(2022, 02, 14));
        arrayFestivales.add(festivalUno); // agrego al array el festival

        Festival festivalDos = new Festival(2022, "Festival peñas 2021", LocalDate.of(2021, 02, 13));
        arrayFestivales.add(festivalDos); // agrego al array el festival
        
        // logica existeFestival()
        for(Festival festival: arrayFestivales) {
            if (festival.existeFestival(anoEdicion, nombre, fechaInicio)) {
                return true; // el festival ya existe
            }
        }
        return false;
    }

    public void setPantalla(PantAdmFestival pantalla) {
        this.pantalla = pantalla;
    }
}
