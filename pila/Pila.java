
package pila;

public class Pila<T> {
    //Atributos
    private Nodo<T> cabeza;
    private int tamanio;

    //Constructores
    public Pila() {
        cabeza = null;
        tamanio = 0;
    }

    //Get
    public int getTamanio() {
         return tamanio;
    }

    //PilaVacia
    public boolean esVacia(){
        return (cabeza == null);
    }

    
    public void apilar(T valor){            //Apilar un elemento
        Nodo<T> nuevo = new Nodo<T>();      //Crear nuevo nodo
        nuevo.setValor(valor);              //Fijar el valor dentro del nodo
        if (esVacia()){
            cabeza = nuevo;                 //Cabeza va a apuntar al nuevo nodo
        } else {
            nuevo.setSiguiente(cabeza);     //Enlazamos el campo siguiente de nuevo a la cabeza
            cabeza = nuevo;                 //La nueva cabeza de la fila pasa a ser el nuevo
        }
        tamanio++;                          //Incrementamos el tamaño

    }
    public T retirar() {
    if (esVacia()) {
        return null;
    }

    T valor = cabeza.getValor(); // guardamos el valor de la cima
    cabeza = cabeza.getSiguiente(); // movemos la cabeza
    tamanio--;
    return valor; // devolvemos el valor retirado
}
    public T cima(){                        //Devuelve el elemento en el tope de la pila
        if (!esVacia())
            return cabeza.getValor();
        else
            return null;
        
    }
}
