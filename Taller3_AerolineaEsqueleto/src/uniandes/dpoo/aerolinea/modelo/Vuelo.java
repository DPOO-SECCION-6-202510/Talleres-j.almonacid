package uniandes.dpoo.aerolinea.modelo;
import uniandes.dpoo.aerolinea.tiquetes.*;
import uniandes.dpoo.aerolinea.modelo.cliente.*;
import uniandes.dpoo.aerolinea.modelo.tarifas.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Vuelo {
    private String fecha;
    private Ruta ruta;
    private Avion avion;
    private Collection<Tiquete> tiquetes;

    public Vuelo(Ruta ruta, String fecha, Avion avion) {
        this.fecha = fecha;
        this.ruta = ruta;
        this.avion = avion;
        this.tiquetes = new ArrayList<>();
    }

    public String getFecha() {
        return fecha;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Avion getAvion() {
        return avion;
    }

    public Collection<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
        int vendidos = 0;
        int tarifa = calculadora.calcularTarifa(this, cliente); // Se debe pasar el cliente según el UML

        for (int i = 0; i < cantidad; i++) {
            if (tiquetes.size() < avion.getCapacidad()) { 
                Tiquete nuevoTiquete = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
                tiquetes.add(nuevoTiquete);
                GeneradorTiquetes.registrarTiquete(nuevoTiquete);
                vendidos++;
            } else {
                break; // No hay más espacio en el avión
            }
        }
        return vendidos;
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vuelo vuelo = (Vuelo) obj;
        return Objects.equals(fecha, vuelo.fecha) &&
               Objects.equals(ruta, vuelo.ruta) &&
               Objects.equals(avion, vuelo.avion);
    }
    
    public int hashCode() {
        return Objects.hash(fecha, ruta, avion);
    }
}
