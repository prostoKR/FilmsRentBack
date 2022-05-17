package lt.vtmc.restapi.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtmc.restapi.model.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

	Optional<Producer> findProducerByName(String producerName);
	Optional<Producer> findProducerByCountry(String producerCountry);
	
}
