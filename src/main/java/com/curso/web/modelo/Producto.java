package com.curso.web.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String name;
	private String description;
	private String urlImage;
	private double price;
	private int inventory;
	@ManyToOne
	private Usuario usuario;
	/**
	 * 
	 */
	public Producto() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param urlImage
	 * @param price
	 * @param inventory
	 */
	
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param urlImage
	 * @param price
	 * @param inventory
	 * @param usuario
	 */
	public Producto(int id, String name, String description, String urlImage, double price, int inventory,
			Usuario usuario) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.urlImage = urlImage;
		this.price = price;
		this.inventory = inventory;
		this.usuario = usuario;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name + ", description=" + description + ", urlImage=" + urlImage
				+ ", price=" + price + ", inventory=" + inventory + "]";
	}
	
	
}
