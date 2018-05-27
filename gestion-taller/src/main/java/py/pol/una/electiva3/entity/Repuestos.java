package py.pol.una.electiva3.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author dlopez
 */
@Entity
@Table(name = "repuestos")
public class Repuestos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_repuesto")
    private Integer codRepuesto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "precio")
    private int precio;

    public Repuestos() {
    }

    public Repuestos(Integer codRepuesto) {
        this.codRepuesto = codRepuesto;
    }

    public Repuestos(Integer codRepuesto, String nombre, int precio) {
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
    public int hashCode() {
        int hash = 0;
        hash += (codRepuesto != null ? codRepuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repuestos)) {
            return false;
        }
        Repuestos other = (Repuestos) object;
        if ((this.codRepuesto == null && other.codRepuesto != null) || (this.codRepuesto != null && !this.codRepuesto.equals(other.codRepuesto))) {
            return false;
        }
        return true;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Repuestos [codRepuesto=");
		builder.append(codRepuesto);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", precio=");
		builder.append(precio);
		builder.append("]");
		return builder.toString();
	}
    
}
