package DreamCatsBacked.BackCats.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DreamCatsBacked.BackCats.entity.CatBreed;
import DreamCatsBacked.BackCats.repository.CatBreedRepository;

@Service
public class CatBreedService {

	private final CatBreedRepository catBreedRepository;

	@Autowired
	public CatBreedService(CatBreedRepository catBreedRepository) {
		this.catBreedRepository = catBreedRepository;
	}

	public List<CatBreed> findAllCatBreeds() {
		return catBreedRepository.findAll();
	}

	public Optional<CatBreed> findCatBreedById(Long id) {
		return catBreedRepository.findById(id);
	}

	public CatBreed saveCatBreed(CatBreed catBreed) {
		return catBreedRepository.save(catBreed);
	}

	public void deleteCatBreed(Long id) {
		catBreedRepository.deleteById(id);
	}
}
