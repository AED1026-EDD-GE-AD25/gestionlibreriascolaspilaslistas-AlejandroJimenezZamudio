package miPrincipal.modelo;

import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import pila.Pila;
import cola.Cola;
import utilerias.Fecha;
import miPrincipal.servicio.ServicioDatos;
import java.util.Scanner;

public class Libreria{
    ServicioDatos dataService;
    ListaDoble<Libro> listaLibros;
    Cola<Libro> colaLibros;
    Pila<Libro> pilaLibrosEliminados;
    ListaDoble<Pedido> listaPedidos;
    Scanner scanner; 

    public Libreria(){
        dataService = new ServicioDatos();
        scanner = new Scanner(System.in);
        listaLibros = new ListaDoble<>();
        colaLibros = new Cola<>();
        pilaLibrosEliminados = new Pila<>();
        listaPedidos = new ListaDoble<>();

    }

    public void agregarLibro(Libro libro){
        listaLibros.agregar(libro);
        
           
        
    }

    
    public ListaDoble<Libro> obtenerLibros(){
        return listaLibros;
    }

    public boolean agregarLibroCola(Libro libro){
        colaLibros.encolar(libro);
        return true;

    }

    public Libro obtenerLibroCola(){
        return colaLibros.desencolar();
       
        

    }
    public Libro obtenerLibroPila(){
        return pilaLibrosEliminados.cima();


    }

    public Cola<Libro> mostrarReservaLibros() {
        return colaLibros;
    }

    public Libro crearLibro(String titulo, String autor, String isbn){
        return new Libro(titulo, autor, isbn);
    }

    public Pedido crearPedido(Libro libro, Fecha fecha){
        Pedido pedido = new Pedido(libro, fecha);
        listaPedidos.agregar(pedido);
        return pedido;

    }

    public boolean devolverLibro(Libro libro) throws PosicionIlegalException{
       if (listaLibros.contiene(libro)) {
        listaLibros.remover(libro);
        return true;
       }
       return false;
    }

    public Libro eliminarUltimoLibro() throws PosicionIlegalException{
        if (listaLibros.getTamanio() == 0)
        return null;
        Libro libro = listaLibros.remover(listaLibros.getTamanio() - 1);
        pilaLibrosEliminados.apilar(libro);
        return libro;
    }

    public Libro deshacerEliminarLibro() throws PosicionIlegalException{
        if (pilaLibrosEliminados.esVacia()) return null;
        Libro libro = pilaLibrosEliminados.retirar();
        listaLibros.agregar(libro);
        return libro;

    }

    public Libro buscarLibro(String isbn) {
        for (int i = 0; i < listaLibros.getTamanio(); i++) {
            try {
                Libro l = listaLibros.getValor(i);
                if (l.getIsbn().equals(isbn))
                    return l;
            } catch (PosicionIlegalException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    public void mostrarLibros() {
        System.out.println(listaLibros.toString());
    }


}