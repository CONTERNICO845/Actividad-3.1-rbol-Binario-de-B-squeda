package back_end;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ArbolBusqueda {

    private NodoABB raiz;

    public ArbolBusqueda() {
        this.raiz = null;
    }

    public void insertar(Empleado empleado) {
        if (empleado == null) {
            return;
        }
        raiz = insertarRec(raiz, empleado);
    }

    private NodoABB insertarRec(NodoABB nodo, Empleado empleado) {
        if (nodo == null) {
            return new NodoABB(empleado);
        }

        int idActual = nodo.getDato().id();
        int idNuevo = empleado.id();

        if (idNuevo < idActual) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), empleado));
        } else if (idNuevo > idActual) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), empleado));
        }

        return nodo;
    }

    public Empleado buscar(Integer id) {
        if (id == null || raiz == null) {
            return null;
        }
        NodoABB encontrado = buscarRec(raiz, id.intValue());
        return encontrado == null ? null : encontrado.getDato();
    }

    private NodoABB buscarRec(NodoABB nodo, int id) {
        if (nodo == null) {
            return null;
        }

        int idActual = nodo.getDato().id();

        if (id == idActual) {
            return nodo;
        } else if (id < idActual) {
            return buscarRec(nodo.getIzquierdo(), id);
        } else {
            return buscarRec(nodo.getDerecho(), id);
        }
    }

    public void eliminar(Integer id) {
        if (id == null || raiz == null) {
            return;
        }
        raiz = eliminarRec(raiz, id.intValue());
    }

    private NodoABB eliminarRec(NodoABB nodo, int id) {
        if (nodo == null) {
            return null;
        }

        int idActual = nodo.getDato().id();

        if (id < idActual) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), id));
            return nodo;
        } else if (id > idActual) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), id));
            return nodo;
        }

        if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
            return null;
        }

        if (nodo.getIzquierdo() == null) {
            return nodo.getDerecho();
        }

        if (nodo.getDerecho() == null) {
            return nodo.getIzquierdo();
        }

        NodoABB sucesor = minimo(nodo.getDerecho());
        nodo.setDato(sucesor.getDato());
        nodo.setDerecho(eliminarRec(nodo.getDerecho(), sucesor.getDato().id()));

        return nodo;
    }

    private NodoABB minimo(NodoABB nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    public String mostrarInOrden() {
        StringBuilder texto = new StringBuilder();
        inOrden(raiz, texto);
        return texto.toString();
    }

    private void inOrden(NodoABB nodo, StringBuilder texto) {
        if (nodo != null) {
            inOrden(nodo.getIzquierdo(), texto);
            texto.append(nodo.getDato().toString()).append("\n");
            inOrden(nodo.getDerecho(), texto);
        }
    }

    public String mostrarPreOrden() {
        StringBuilder texto = new StringBuilder();
        preOrden(raiz, texto);
        return texto.toString();
    }

    private void preOrden(NodoABB nodo, StringBuilder texto) {
        if (nodo != null) {
            texto.append(nodo.getDato().toString()).append("\n");
            preOrden(nodo.getIzquierdo(), texto);
            preOrden(nodo.getDerecho(), texto);
        }
    }

    public String mostrarPostOrden() {
        StringBuilder texto = new StringBuilder();
        postOrden(raiz, texto);
        return texto.toString();
    }

    private void postOrden(NodoABB nodo, StringBuilder texto) {
        if (nodo != null) {
            postOrden(nodo.getIzquierdo(), texto);
            postOrden(nodo.getDerecho(), texto);
            texto.append(nodo.getDato().toString()).append("\n");
        }
    }

    public int profundidad() {
        return calcularProfundidad(raiz);
    }

    private int calcularProfundidad(NodoABB nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(calcularProfundidad(nodo.getIzquierdo()), calcularProfundidad(nodo.getDerecho()));
    }

    public int amplitud() {
        if (raiz == null) {
            return 0;
        }

        int maxAmplitud = 0;
        ArrayDeque<NodoABB> cola = new ArrayDeque<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            int nodosPorNivel = cola.size();
            if (nodosPorNivel > maxAmplitud) {
                maxAmplitud = nodosPorNivel;
            }

            for (int i = 0; i < nodosPorNivel; i++) {
                NodoABB actual = cola.poll();
                if (actual.getIzquierdo() != null) {
                    cola.add(actual.getIzquierdo());
                }
                if (actual.getDerecho() != null) {
                    cola.add(actual.getDerecho());
                }
            }
        }

        return maxAmplitud;
    }

    public void balancear() {
        if (raiz == null) {
            return;
        }

        List<Empleado> lista = new ArrayList<>();
        llenarListaInOrden(raiz, lista);
        if (lista.size() <= 1) {
            return;
        }

        raiz = null;
        raiz = construirBalanceado(lista, 0, lista.size() - 1);
    }

    private void llenarListaInOrden(NodoABB nodo, List<Empleado> lista) {
        if (nodo != null) {
            llenarListaInOrden(nodo.getIzquierdo(), lista);
            lista.add(nodo.getDato());
            llenarListaInOrden(nodo.getDerecho(), lista);
        }
    }

    private NodoABB construirBalanceado(List<Empleado> lista, int inicio, int fin) {
        if (inicio > fin) {
            return null;
        }

        int medio = (inicio + fin) / 2;
        NodoABB nuevo = new NodoABB(lista.get(medio));
        nuevo.setIzquierdo(construirBalanceado(lista, inicio, medio - 1));
        nuevo.setDerecho(construirBalanceado(lista, medio + 1, fin));
        return nuevo;
    }

    public void destruirArbol() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public String mostrarEstructura() {
        StringBuilder sb = new StringBuilder();
        if (raiz == null) {
            return "Árbol vacío.";
        }
        estructuraRec(raiz, "", true, sb);
        String resultado = sb.toString();
        return resultado.isEmpty() ? "Árbol vacío." : resultado;
    }

    private void estructuraRec(NodoABB nodo, String prefijo, boolean esUltimo, StringBuilder sb) {
        if (nodo == null) {
            return;
        }
        sb.append(prefijo);
        sb.append(esUltimo ? "└── " : "├── ");
        sb.append(nodo.getDato().id()).append(" - ").append(nodo.getDato().nombre()).append("\n");
        estructuraRec(nodo.getIzquierdo(), prefijo + (esUltimo ? "    " : "│   "), false, sb);
        estructuraRec(nodo.getDerecho(), prefijo + (esUltimo ? "    " : "│   "), true, sb);
    }
}
