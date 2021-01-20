/*
 * Copyright (C) 2020 Oscar Arenas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package modelo;

/**
 *
 * @author Oscar Arenas
 */
public class ListaSE {

    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private int n;

    public ListaSE() {
        primerNodo = null;
        ultimoNodo = null;
        n = 0;
    }

    public boolean agregar(double dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (primerNodo != null) {
            ultimoNodo.siguiente = nuevoNodo;
        } else {
            primerNodo = nuevoNodo;
        }

        ultimoNodo = nuevoNodo;
        n++;
        return true;
    }

    public boolean agregar(int indice, double valor) {
        if (indice >= 0 && indice <= n) {
            if (indice == n) {
                return agregar(valor);
            } else {
                Nodo actual = primerNodo;
                Nodo anterior = null;
                int i = 0;

                while (i < indice) {
                    i++;
                    anterior = actual;
                    actual = actual.siguiente;
                }
                Nodo nuevoNodo = new Nodo(valor, actual);

                if (anterior == null) {
                    primerNodo = nuevoNodo;
                } else {
                    anterior.siguiente = nuevoNodo;
                }

                n++;
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(double dato) {
        if (primerNodo != null) {
            Nodo actual = primerNodo;
            Nodo anterior = null;

            while (actual != null && actual.dato != dato) {
                anterior = actual;
                actual = actual.siguiente;
            }

            if (actual != null) {
                if (anterior == null) {
                    primerNodo = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                if (actual == ultimoNodo) {
                    ultimoNodo = anterior;
                }
                n--;
                return true;
            }
        }
        return false;
    }

    public int tamanio() {
        return n;
    }

    @Override
    public String toString() {
        String cadena = "";

        if (primerNodo != null) {
            Nodo actual = primerNodo;

            while (actual.siguiente != null) {
                cadena = cadena + actual.dato + ", ";
                actual = actual.siguiente;
            }
            cadena = cadena + actual.dato;
        }

        return "[" + cadena + "]";
    }
}
