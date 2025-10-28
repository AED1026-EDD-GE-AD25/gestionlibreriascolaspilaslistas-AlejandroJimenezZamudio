package pila;
public class Nodo<T>{
    //Atributos
    private T valor;
    private Nodo<T> siguiente;

    //Constructores
    public Nodo(){
        valor = null;
        siguiente = null;

    }
    //Gets-Sets
    public T getValor() {
        return valor;

    }
    public void setValor(T valor) {
        this.valor = valor;

    }
    public Nodo<T> getSiguiente() {
        return siguiente;

    }
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;

    }
}