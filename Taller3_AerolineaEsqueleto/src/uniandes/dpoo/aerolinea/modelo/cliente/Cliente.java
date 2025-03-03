package uniandes.dpoo.aerolinea.modelo.cliente;
import uniandes.dpoo.aerolinea.tiquetes.*;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import java.util.Collection;
import java.util.HashSet;

public abstract class Cliente{
	
	private Collection<Tiquete> tiquetesSinUsar;
    private Collection<Tiquete> tiquetesUsados;

    public Cliente() {
        this.tiquetesSinUsar = new HashSet<>();
        this.tiquetesUsados = new HashSet<>();
    }

    public abstract String getTipoCliente();
    public abstract String getIdentificador();

    public void agregarTiquete(Tiquete tiquete) {
        tiquetesSinUsar.add(tiquete);
    }

    public void usarTiquetes(Vuelo vuelo) {
        Collection<Tiquete> usados = new HashSet<>();
        for (Tiquete t : tiquetesSinUsar) {
            if (t.getVuelo().equals(vuelo) && !t.esUsado()) {
                t.marcarComoUsado();
                usados.add(t);
                tiquetesUsados.add(t);
            }
        }
        tiquetesSinUsar.removeAll(usados);
    }

    public int calcularValorTotalTiquetes() {
        int total = 0;
        for (Tiquete t : tiquetesSinUsar) {
            total += t.getTarifa();
        }
        return total;
    }
}