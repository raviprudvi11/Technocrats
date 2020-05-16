package com.technocrat.product.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "name")
	private String name;
	@Column(name = "available")
	private int available;
	@Column(name = "price")
	private int price;
	@Column(name = "manufacturer")
	private String manufacturer;
	@Column(name = "required")
	private String required;
	@Column(name = "description")
	private String description;
	@Column(name = "storeid")
	private int storeid;
	@Column(name = "chemicalformula")
	private String chemicalformula;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStoreid() {
		return storeid;
	}

	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}

	public String getChemicalformula() {
		return chemicalformula;
	}

	public void setChemicalformula(String chemicalformula) {
		this.chemicalformula = chemicalformula;
	}

	public String toString() {
		return "Product [name=" + name + ", available=" + available + ", price=" + price + ", manufacturer="
				+ manufacturer + ", required=" + required + ", description=" + description + ",storeid=" + storeid
				+ ",chemicalformula=" + chemicalformula + "]";
	}
}
