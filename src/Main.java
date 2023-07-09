public class Main {
    public static void main(String[] args) {
        Login inicial = new Login(null);
    }

    /*public static void cargaCompleta() {
        LinkedList<Usuario> listaUsuarios = LecturaArchivos.leerArchivoUsuarios();
        LinkedList<Libro> listaLibros = LecturaArchivos.leerArchivoLibros();
        configPrincipal();
        MenuLogin();
    }

    public static void configPrincipal() {
        double min = -1.0;
        double max = 1.0;

        StdDraw.setXscale(min,max);
        StdDraw.setYscale(min,max);

        StdDraw.enableDoubleBuffering();
        StdDraw.clear();

        StdDraw.setTitle("Bibliotech");
        StdDraw.setCanvasSize(500,500);

        StdDraw.setPenColor(Color.gray);
        StdDraw.filledSquare(0,0,1);
        StdDraw.picture(0.1,0.9,"logo.png",0.2,0.2);
    }

    public static void MenuLogin() {
        StdDraw.setPenColor(Color.white);
        StdDraw.line(0,0.05,1,0.05);
        StdDraw.textLeft(0,0.025,"Taller N°5 - Programación Avanzada");
        StdDraw.textRight(1,0.025,"Julio, 2023");
        StdDraw.textLeft(0,0.15,"**Escriba directamente sus credenciales, cuando termine de escribir");
        StdDraw.textLeft(0,0.12, "una aprete ENTER  y proceda a escribir la siguiente.");

        //Botones Menu Login
            //RUT
        StdDraw.text(0.5,0.8,"RUT");
        StdDraw.filledRectangle(0.5,0.7,0.2,0.05);
            //Contrasenia
        StdDraw.text(0.5,0.6,"Contrasenia");
        StdDraw.filledRectangle(0.5,0.5,0.2,0.05);
            //Iniciar sesion
        StdDraw.filledRectangle(0.5,0.4,0.1,0.025);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(0.5,0.4,"Iniciar Sesion");



        StdDraw.show();
    }*/
}