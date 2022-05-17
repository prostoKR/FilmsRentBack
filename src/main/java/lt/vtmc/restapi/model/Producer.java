package lt.vtmc.restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Entity
public class Producer {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String country;
	
	
	public Producer(String name, String country) {
		this.name = name;
		this.country = country;
	
	}
	

}