package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
public class CalculadoraTarifasTemporadaBaja {
	
	protected static final int COSTO_POR_KM_NATURAL = 600;
    protected static final int COSTO_POR_KM_CORPORATIVO = 900;
    protected static final double DESCUENTO_PEQ = 0.02;
    protected static final double DESCUENTO_MEDIANAS = 0.1;
    protected static final double DESCUENTO_GRANDES = 0.2;

    public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        int distancia = vuelo.getRuta().getDuracion();
        int costoPorKm = cliente.getTipoCliente().equals("Corporativo") ? COSTO_POR_KM_CORPORATIVO : COSTO_POR_KM_NATURAL;
        return distancia * costoPorKm;
    }

    public double calcularPorcentajeDescuento(Cliente cliente) {
        int valorTotal = cliente.calcularValorTotalTiquetes();
        if (valorTotal >= 5000000) {
            return DESCUENTO_GRANDES;
        } else if (valorTotal >= 2000000) {
            return DESCUENTO_MEDIANAS;
        } else if (valorTotal >= 1000000) {
            return DESCUENTO_PEQ;
        } else {
            return 0.0;
        }
    }
}
