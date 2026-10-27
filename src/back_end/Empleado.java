package back_end;

public record Empleado(
        int id,
        String nombre,
        String cargo,
        String area,
        double sueldo) {

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + cargo + " | " + area + " | $" + sueldo;
    }
}
