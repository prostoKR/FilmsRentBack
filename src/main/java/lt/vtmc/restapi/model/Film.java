package lt.vtmc.restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Film {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String storyline;
	
	@ManyToOne
	@JoinColumn(name="producer_id")
	private Producer producer;
	
	

}
