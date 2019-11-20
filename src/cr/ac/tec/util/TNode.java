package cr.ac.tec.util;


import java.io.Serializable;
/**
 * Technological institute of Costa Rica
 * Computer Engineering
 * Course: de Algoritmos y estructuras de datos I
 * Project II: TextFinder
 * JDK 11
 * Description: Node that stores data in the TecLinkedList. Serializable
 * @author Jose Morales Vargas
 * @since September 2019
 */
public class TNode<T> implements Serializable {
    TNode<T> next;
    TNode<T> prev;
    T data;

    public TNode(){

    }
    /**
     * Constructor of the TNode
     * @param data data to be stored
     */
    public TNode(T data){
        this.data = data;
        this.next = this.prev = null;
    }

    public TNode<T> getNext() {
        return next;
    }

    public void setNext(TNode<T> next) {
        this.next = next;
    }

    public TNode<T> getPrev() {
        return prev;
    }

    public void setPrev(TNode<T> prev) {
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
