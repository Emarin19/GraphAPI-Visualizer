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

    /**
     * Constructor of the TNode
     * @param data data to be stored
     */
    public TNode(T data){
        this.data = data;
        this.next = this.prev =null;
    }

}
