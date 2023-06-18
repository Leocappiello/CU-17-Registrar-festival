public class Test {
    public static void main(String args[]) {
        GestorFestival gestor = new GestorFestival(); // gestor sin pantalla
        PantAdmFestival pantalla = new PantAdmFestival(gestor);   // pantalla
        gestor.setPantalla(pantalla); // asocio la pantalla al gestor
        
        pantalla.opcionRegFestival(); // inicio el CU
    }
}
