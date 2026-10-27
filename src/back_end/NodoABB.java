package back_end;

public class NodoABB {

    private Empleado dato;
    private NodoABB izquierdo;
    private NodoABB derecho;

    public NodoABB(Empleado dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    public Empleado getDato() {
        return dato;
    }

    public void setDato(Empleado dato) {
        this.dato = dato;
    }

    public NodoABB getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoABB izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoABB getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoABB derecho) {
        this.derecho = derecho;
    }
}
