package py.pol.una.electiva3.model;

import java.util.Date;


public class VehiculoModel {

    private String matricula;
    private String modelo;
    private String color;
    private Date fechaentrada;
    private ClienteModel cliente;
    
	public VehiculoModel() {
		super();
	}

	public VehiculoModel(String matricula, String modelo, String color, Date fechaentrada,
			ClienteModel cliente) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.color = color;
		this.fechaentrada = fechaentrada;
		this.cliente = cliente;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getFechaentrada() {
		return fechaentrada;
	}

	public void setFechaentrada(Date fechaentrada) {
		this.fechaentrada = fechaentrada;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehiculoModel [matricula=");
		builder.append(matricula);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", color=");
		builder.append(color);
		builder.append(", fechaentrada=");
		builder.append(fechaentrada);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append("]");
		return builder.toString();
	}
	
    
}
