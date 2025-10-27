package miPrincipal.iu;
import miPrincipal.servicio.ServicioDatos;
import miPrincipal.modelo.Libro;
import miPrincipal.modelo.Pedido;
import miPrincipal.modelo.Libreria;
import java.util.Scanner;
import utilerias.Fecha;
import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import cola.Cola;
import pila.Pila;

import java.util.Scanner;

public class MenuOpciones{
    static Scanner scanner = new  Scanner(System.in);
    static private Libreria libreria = new Libreria();

    public static void agregarLibro(){
        System.out.print("Título del libro: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor del libro: ");
        String autor = scanner.nextLine();

        System.out.print("ISBN del libro: ");
        String isbn = scanner.nextLine();

        Libro libro = libreria.crearLibro(titulo, autor, isbn);

        if (libro != null) {
            libreria.agregarLibro(libro);
            System.out.println("Se agreg el libr");
        } else {
            System.out.println("No se agregó el libro");
        }
        
        

    }
    
    public static void mostrarLibros() throws PosicionIlegalException{
        System.out.println("Lista de libros: ");
        libreria.mostrarLibros();
 
    }

    public static void agregarLibroCola(){
        System.out.print("Título del libro: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor del libro: ");
        String autor = scanner.nextLine();

        System.out.print("ISBN del libro: ");
        String isbn = scanner.nextLine();

        Libro libro = libreria.crearLibro(titulo, autor, isbn);

        if (libro != null) {
            libreria.agregarLibroCola(libro);
            System.out.println("Se agregó a la cola");
        } else {
            System.out.println("No se agregó a lña cola.");
        }
        
        
    }

    public static Libro obtenerLibroCola(){
        Libro libro = libreria.obtenerLibroCola();
        if (libro != null) {
            System.out.println("Libro obtenido: " + libro);
        } else {
            System.out.println("No hay libros en al cola.");
        }
        return libro;
       
     
    }

    public static void mostrarReservaLibros(){
        System.out.println("Libros en la cola: ");
        libreria.mostrarReservaLibros();

    }

    public static void crearPedido(){
        System.out.print("Ingrese el título del libro para el pedido:");
        String tituloPedido = scanner.nextLine();
        System.out.print("Ingrese el autor del libro para el pedido:");
        String autorPedido = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro para el pedido:");
        String isbnPedido = scanner.nextLine();
        Libro libroPedido = libreria.crearLibro(tituloPedido, autorPedido, isbnPedido);
        Pedido pedido=null;
        if (libroPedido!=null){
            pedido = libreria.crearPedido(libroPedido, new Fecha());
            if (pedido !=null)
                System.out.println("Pedido creado exitosamente: "+pedido);
            else
                System.out.println("No fue posible crear el pedido");
        }else{
            System.out.println("Error: no fue posible crear el Libro");
        }
       
    }

    public static void devolverLibro() throws PosicionIlegalException{
        Libro libroDevuelto = libreria.deshacerEliminarLibro();
        if (libroDevuelto != null)
            System.out.println("Se devolvió el libro: " + libroDevuelto);
        else
            System.out.println("No hay libros para devolver");
      
    }

    public static Libro eliminarUltimoLibro() throws PosicionIlegalException{
        Libro libroEliminado = libreria.eliminarUltimoLibro();
        if (libroEliminado != null)
            System.out.println("Se eliminó el libro: " + libroEliminado);
        else
            System.out.println("No hay libros para eliminar");
        return libroEliminado;
       

    }

    public static void deshacerEliminarLibro(){
        try {
            Libro libro = libreria.deshacerEliminarLibro();
            if (libro != null)
                System.out.println("Se deshizo la eliminación del libro " + libro);
            else
                System.out.println("No hay libros para deshacer eliminación.");
        } catch (PosicionIlegalException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


	
}
