/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaapplication6;

/**
 *
 * @author jonathanquishpe
 */
public interface IListaEnlazada<E> {
    int size();
    boolean isEmpty();
    void addFront(E element);
    void addEnd(E element);
    void add(E element, int index) throws IndexOutOfBoundsException;
    E getElement(int index) throws IndexOutOfBoundsException, ListaVaciaException;
    void remove(int index) throws IndexOutOfBoundsException, ListaVaciaException;
    void removeEnd() throws ListaVaciaException;
    void remoFront() throws ListaVaciaException;
}
