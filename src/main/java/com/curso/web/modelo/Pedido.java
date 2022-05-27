package com.curso.web.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String number;
	private String Create_Date;	
	private double total;
	@ManyToOne
	private Usuario usuario;
	@OneToOne(mappedBy="pedido")
	private DetallePedido detallePedido;
	/**
	 * 
	 */
	public Pedido() {
		super();
	}
	/**
	 * @param id
	 * @param number
	 * @param create_Date
	 * @param total
	 */
	public Pedido(int id, String number, String create_Date, double total) {
		super();
		this.id = id;
		this.number = number;
		Create_Date = create_Date;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCreate_Date() {
		return Create_Date;
	}
	public void setCreate_Date(String create_Date) {
		Create_Date = create_Date;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public DetallePedido getDetallePedido() {
		return detallePedido;
	}
	public void setDetallePedido(DetallePedido detallePedido) {
		this.detallePedido = detallePedido;
	}
	@Override
	public String toString() {
		return "Orden [id=" + id + ", number=" + number + ", Create_Date=" + Create_Date + ", total=" + total + "]";
	}
	
}
