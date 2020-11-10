package ar.edu.iua.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="choferes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")

public class Chofer implements Serializable {

	private static final long serialVersionUID = 3759989795563161398L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(nullable = false)
	private long dni;
	
	@OneToMany(targetEntity=Orden.class, mappedBy="chofer", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Orden> ordenList;
	
	@Column()
	private String nombre; 
	@Column()
	private String apellido;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public List<Orden> getOrdenList() {
		return ordenList;
	}
	public void setOrdenList(List<Orden> ordenList) {
		this.ordenList = ordenList;
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
	
	public String checkBasicData()
	{
		if(getDni()==0)
			return "El dni es un atributo obligatorio";
		return null; 
	}
	
	
	
	
	

}