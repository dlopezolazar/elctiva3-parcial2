package py.pol.una.electiva3.model;

public class RepuestoModel {
	
	private Integer codRepuesto;
	private String nombre;
	private int precio;
	
	public RepuestoModel() {
		super();
	}

	public RepuestoModel(Integer codRepuesto, String nombre, int precio) {
		super();
		this.codRepuesto = codRepuesto;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Integer getCodRepuesto() {
		return codRepuesto;
	}

	public void setCodRepuesto(Integer codRepuesto) {
		this.codRepuesto = codRepuesto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RepuestoModel [codRepuesto=");
		builder.append(codRepuesto);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", precio=");
		builder.append(precio);
		builder.append("]");
		return builder.toString();
	}
	
	

}
