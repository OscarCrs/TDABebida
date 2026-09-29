package verificacionfuncional;

/**
 * Autor: Oscar Cortes Solares
 * Propósito: TDA que representa una bebida de café. 
 * Implementa encapsulamiento, herencia, y métodos de lógica (incluyendo recursividad).
 */
public final class BebidaCafe extends Bebidas{
    
    // Atributos propios del modelo (Encapsulamiento estricto)
    private String tipoGrano;
    private double precioBase;
    private int cantidadStock;

    
      //Constructor con validaciones pertinentes.

    public BebidaCafe(String nombre, String tipoGrano, double precioBase, int cantidadStock) {
        super(nombre);
        this.tipoGrano = tipoGrano;
        setPrecioBase(precioBase);       
        setCantidadStock(cantidadStock); 
    }

    //GETTERS Y SETTERS

    public String getTipoGrano() { 
        return tipoGrano; 
    }
    
    public void setTipoGrano(String tipoGrano) { 
        this.tipoGrano = tipoGrano; 
    }

    public double getPrecioBase() { 
        return precioBase; 
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase > 0) {
            this.precioBase = precioBase;
        } else {
            this.precioBase = 10.0; // Valor por defecto si es inválido
        }
    }

    public int getCantidadStock() { 
        return cantidadStock; 
    }

    public void setCantidadStock(int cantidadStock) {
        if (cantidadStock >= 0) {
            this.cantidadStock = cantidadStock;
        } else {
            this.cantidadStock = 0; // Evita stock negativo
        }
    }

    //Metodos de logica

    //1.  Registra una venta y disminuye el stock si es posible.
    public boolean vender(int cantidad) {
        if (cantidad > 0 && cantidad <= this.cantidadStock) {
            this.cantidadStock -= cantidad;
            return true; // Venta exitosa
        }
        return false; // Sin stock suficiente
    }

    //2. Abastece el inventario aumentando el stock.
    public void abastecer(int cantidad) {
        if (cantidad > 0) {
            this.cantidadStock += cantidad;
        }
    }

    //Lógica 3: Calcula el valor total en dinero del inventario actual de esta bebida.
    public double calcularValorInventario() {
        return this.cantidadStock * this.precioBase;
    }

     //Lógica 4 RECURSIVIDAD: Calcula un precio de fidelidad aplicando un 
     // 2% de descuento sucesivo por cada nivel de cliente acumulado.
     
     //para nivelFidelidad Cantidad de veces que se aplicará el descuento.
     //para precioActual El precio sobre el cual se calcula el descuento recursivo.
     //return El precio final calcular recursivamente.
  
    public double calcularPrecioFidelidadRecursivo(int nivelFidelidad, double precioActual) {
        //Si ya no hay niveles de fidelidad por aplicar, retorna el precio.
        if (nivelFidelidad <= 0) {
            return precioActual;
        }
       //Disminuye el nivel y aplica un 2% de descuento al precio actual.
        return calcularPrecioFidelidadRecursivo(nivelFidelidad - 1, precioActual * 0.98);
    }
}
