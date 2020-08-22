package jison.ApparelSpringApp;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Apparel {
	
	private @Id @GeneratedValue long id;
	private String name;
	private String brand;
	private String size;
	private String type;
	
	Apparel() {}
	
	Apparel(String name, String brand, String size, String type) {
		this.name = name;
		this.brand = brand;
		this.size = size;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public String getSize() {
		return size;
	}

	public String getType() {
		return type;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if(!(o instanceof Apparel))
			return false;
		Apparel apparel = (Apparel) o;
		return Objects.equals(this.name, apparel.name) && Objects.equals(this.brand, apparel.brand) &&
				Objects.equals(this.size, apparel.size) && Objects.equals(this.type, apparel.type) ;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.name, this.brand, this.size, this.type);
	}
	
	@Override
	public String toString() {
		return "Apparel{id=" + this.id + ", name=" + this.name + ", brand=" + this.brand + ", size=" + this.size + ", type=" + this.type + "\'}";
	}
}
