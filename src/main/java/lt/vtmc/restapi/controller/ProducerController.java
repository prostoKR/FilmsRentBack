package lt.vtmc.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.vtmc.restapi.model.Producer;
import lt.vtmc.restapi.payload.ProducerRequest;
import lt.vtmc.restapi.repository.ProducerRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/producers")
public class ProducerController {
	
	@Autowired //automatinis uzpildymas
	public ProducerRepository producerRepo;
	
	@GetMapping
	public List<Producer> getProducer() {
		return producerRepo.findAll();

	}

	@GetMapping("/{id}")
	public Producer getProducer(@PathVariable Long id) {
		return producerRepo.findById(id).get();
	}

	@PostMapping
	public Producer postProducer(@RequestBody ProducerRequest producerRequest) {
		System.out.println("CREATE: " + producerRequest.getName()+producerRequest.getCountry());
		Producer producer = new Producer();
		producer.setName(producerRequest.getName());
		producer.setCountry(producerRequest.getCountry());
		return producerRepo.save(producer);
	}

	@DeleteMapping("/{id}")
	public void deleteProducer(@PathVariable Long id) {
		producerRepo.deleteById(id);
	}
	
//	ResponseEntity
	@PutMapping("/{id}")
	public ResponseEntity<Producer> updateProducers(@PathVariable Long id, @RequestBody Producer producerDetails) {
		Producer producer = producerRepo.findById(id).orElseThrow() ;
		
		producer.setName(producerDetails.getName());
		producer.setCountry(producerDetails.getCountry());
		final Producer updatedProducer = producerRepo.save(producer);
        return ResponseEntity.ok(updatedProducer);
	}
}