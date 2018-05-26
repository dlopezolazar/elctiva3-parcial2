package py.pol.una.electiva3.model;


public class ClienteModel {

    private Integer dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    
	public ClienteModel() {
		super();
	}

	public ClienteModel(Integer dni, String nombre, String apellido, String direccion, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClienteModel [dni=");
		builder.append(dni);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido=");
		builder.append(apellido);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append("]");
		return builder.toString();
	}
    
    
    
}
