package lt.vtmc.restapi.payload;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class FilmRequest {

	private String title;
	private String storyline;
	private String producerName;
	
	
	
}
