import java.time.LocalDate;
import java.util.ArrayList;

public class Festival {
    public Festival(int anoEdicion, String nombre, LocalDate fechaInicio) {
        this.anoEdicion = anoEdicion;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
    }

    private int anoEdicion;
    private int descuentoVentaAnticipada;
    private String nombre;
    private int porcentajeDevolucionPorAnulacion;
    private boolean vigente;

    private LocalDate fechaInicio;
    private ArrayList<DiaFestival> diaFestival;

    public boolean existeFestival(int anoEdicion, String nombre, LocalDate fechaInicio) {
        if (anoEdicion == this.anoEdicion && nombre == this.nombre && fechaInicio == this.fechaInicio) {
            return true;
        }
        return false;
    }
}
