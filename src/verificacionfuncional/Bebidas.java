package verificacionfuncional;

/**
 * Autor: Oscar Cortes Solares
 * Propósito: Clase base para la jerarquía de bebidas.
 */
public class Bebidas {
    
    protected String nombre;

    public Bebidas(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            this.nombre = "Bebida Genérica";
        } else {
            this.nombre = nombre;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}