package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural {
	
	public static String NATURAL ="Natural";
	private String nombre;
	
	public ClienteNatural(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTipoCliente() {
		return NATURAL;
	}
	
	public String getIdentificador(){
		return nombre;
	}
}
