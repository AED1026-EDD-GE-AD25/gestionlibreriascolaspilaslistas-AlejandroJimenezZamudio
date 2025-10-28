package miPrincipal.modelo;

import utilerias.Fecha;

public class Pedido {
    //Atributos
    private Libro libro;
    private Fecha fechaPedido;
    

    //Constructores
    public Pedido() {
        //

    }
    public Pedido(Libro libro, Fecha fechaPedido) {
        this.libro = libro;
        this.fechaPedido = fechaPedido;

    }

    //Gets-Sets
    public Libro getLibro() {
        return libro;

    }
    public void setLibro(Libro libro) {
        this.libro = libro;

    }
    public Fecha getFechaPedido() {
        return fechaPedido;

    }
    public void setFechaPedido(Fecha fechaPedido) {
        this.fechaPedido = fechaPedido;

    }

    //ToString
    @Override
    public String toString() {
        return "Pedido [libro=" + libro + ", fechaPedido=" + fechaPedido + "]";

    }
}