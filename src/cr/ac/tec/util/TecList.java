package cr.ac.tec.util;

import java.io.Serializable;
import java.util.Iterator;
/**
 * Technological Institute of Costa Rica
 * Computer Engineering
 * Course: de Algoritmos y estructuras de datos I
 * Project II: TextFinder
 * JDK 11
 * Description: Custom Linked List object. Can perform many standard list operations plus some more
 * specific operations.
 * @author Jose Morales Vargas
 * @since October 2019
 */
public class TecList<T> implements Iterable<T>, Serializable {
    private TNode<T> first;
    private TNode<T> last;

    /**
     * Default constructor for a Teclst which is an implementation of doubly Linked List
     * The way data is stored is using a TNode object
     * @see TNode
     */
    public TecList(){
        first = last = null;
    }

    /**
     * Creates a new TNode object which stores the value specified. Adds the node to the Teclst in the last position
     * @param value value to storage
     */
    public void add(T value){
        if (first==null) {
            first = new TNode<T>(value);
            first.prev = null;
            last = first;
        }else{
            TNode<T> elemento = new TNode(value);
            elemento.prev =last;
            last.next = elemento;
            last=elemento;
        }
    }

    /**
     * Creates a new TNode object per value specified. Adds the nodes to the Teclst
     * @param items Collection of items to be added to the Teclst
     */
    public void addAll(T ...items){
        for(T i : items){
            add(i);
        }
    }

    /**
     * Creates a new TNode object which stores the value specified. Adds the node to the Teclst in the index
     * specified
     * @param value value to storage
     * @param index index in which the value will be positioned
     */
    public void insert(T value, int index){
        if(index == 0){
            if(first!=null){
                first.prev = new TNode<>(value);
                first.prev.next = first;
                first = first.prev;
            }else{
                first = last = new TNode<>(value);
            }
        }else if(index == size()-1){
            TNode<T> newNode = new TNode<>(value);
            last.prev.next = newNode;
            newNode.prev = last.prev;
            newNode.next = last;
            last.prev = newNode;
        }else if(index<size()-1){

            TNode current = first;
            for(int i=0; i<index; i++){
                current = current.next;
            }
            TNode<T> newNode = new TNode<>(value);
            current.prev.next = newNode;
            newNode.prev = current.prev;
            current.prev = newNode;
            newNode.next = current;
        }
        else if(index==size()){

            add(value);
        }
    }

    public void reinsert(T value, int index){
        if(index == 0){
            if(first!=null){
                first.data = value;
            }
            else{
                first = last = new TNode<>(value);
            }
        }
        else if(index == size()-1){
            last.data = value;
        }
        else {
            int counter =0;
            TNode current = first;
            while (counter!=index){
                current = current.next;
                counter++;
            }
            current.data = value;
        }
    }

    /**
     * Returns the data stored in the TNode at the position specified
     * @param index position of the list of the value to be checked
     * @return value of TNode at index
     */
    public T get(int index){
        TNode<T> current = first;
        for(int i=0; i<index; i++){
            current = current.next;
        }
        return current.data;
    }

    /**
     * Deletes the reference to a TNode at an specified position, returns its value
     * @param index position of TNode in the Teclst
     * @return value of the TNode at the position specified
     */
    public T pop(int index){
        if(first != null && last!=null) {
            int listSize = size();
            T data;
            if (index == listSize - 1) {
                data = last.data;
                removeLast();
            } else if (index == 0) {
                data = first.data;
                removeFirst();
            } else {
                TNode<T> current = first;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
                data=current.data;
            }
            return data;
        }
        return null;
    }

    /**
     * deletes the reference to a TNode
     * @param nodeT TNode object to be removed
     */
    public void remove(TNode<T> nodeT){
        if(nodeT.equals(first)){
            removeFirst();
        }else if(nodeT.equals(last)){
            removeLast();
        }else{
            nodeT.prev.next = nodeT.next;
            nodeT.next.prev= nodeT.prev;
        }
    }
    public void removeValue(T value){
        TNode<T> current = first;
        while(!current.data.equals(value) && current.next!=null){
            current = current.next;
        }
        if(current.data.equals(value)) {
            remove(current);
        }
    }

    /**
     * removes first element of list
     */
    public void removeFirst(){
        if (first!= null) {
            if(first.next!=null) {
                first = first.next;
                first.prev= null;
            }else{
                first=last=null;
            }
        }
    }

    /**
     * removes last element of list
     */
    public void removeLast(){
        if (last!= null) {
            if (last.prev!=null) {
                last = last.prev;
                last.next =null;
            }else{
                last=first=null;
            }
        }
    }

    /**
     * counts the elements in the list
     * @return count of elements in the list
     */
    public int size(){
        int cnt = 0;
        for (T nodeData : this){
            cnt++;
        }
        return cnt;
    }

    /**
     * returns first TNode reference
     * @return first TNode
     */
    public TNode<T> getFirst() {
        return first;
    }

    /**
     * returns last TNode reference
     * @return last node
     */
    public TNode<T> getLast() {
        return last;
    }

    /**
     *  returns value of first TNode
     * @return value of first node
     */
    public T getFirstValue() {
        return first.data;
    }

    /**
     * checks the value stored on the last TNode
     * @return value of last TNode
     */
    public T getLastValue() {
        return last.data;
    }

    /**
     * checks if the list has more than 0 elements
     * @return if the list is empty, true
     */
    public boolean isEmpty(){
        return first == null;
    }

    /**
     * Checks if a value is stored in any node of the list
     * @param value value to be looked for
     * @return whether the value is or not contained in the list
     */
    public boolean contains(T value){
        boolean contains=false;
        for (T nodeData : this){
            if (value.equals(nodeData)) {
                contains = true;
            }
        }
        return contains;
    }

    /**
     * counts how many Nodes hold the value specified
     * @param value value to be looked for
     * @return times the value is stored
     */
    public int nodesWithValue(T value){
        int cnt = 0;
        for (T nodeData: this){
            if (value.equals(nodeData)) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * override of standard toString method
     * @return String representation of self
     */
    @Override
    public String toString() {
        String toString = "[|-|";
        for (T value:this) {
            toString += value.toString()+ "|-|";
        }
        toString+="]";
        return toString;
    }

    /**
     * Defines the iterator for the list to use in for each loop
     * @return iterator object for the Teclst
     */
    @Override
    public Iterator<T> iterator() {
        return new TecListIterator(first);
    }
}
