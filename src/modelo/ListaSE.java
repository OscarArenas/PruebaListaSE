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

    public void agregar(double dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (primerNodo != null) {
            ultimoNodo.siguiente = nuevoNodo;
        } else {
            primerNodo = nuevoNodo;
        }

        ultimoNodo = nuevoNodo;
        n++;
    }

    public boolean eliminar(int indice) {
        if (indice >= 0 && indice < n) {
            Nodo actual = primerNodo;
            Nodo anterior = null;

            while (indice-- > 0) {
                anterior = actual;
                actual = actual.siguiente;
            }
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
