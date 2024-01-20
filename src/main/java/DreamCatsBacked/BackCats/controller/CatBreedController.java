package DreamCatsBacked.BackCats.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DreamCatsBacked.BackCats.entity.CatBreed;
import DreamCatsBacked.BackCats.payload.CatBreedDTO;
import DreamCatsBacked.BackCats.service.CatBreedService;

@RestController
@RequestMapping("/api/catbreeds")
public class CatBreedController {

	private final CatBreedService catBreedService;

	@Autowired
	public CatBreedController(CatBreedService catBreedService) {
		this.catBreedService = catBreedService;
	}

	@GetMapping
	public List<CatBreedDTO> getAllCatBreeds() {
		List<CatBreed> breeds = catBreedService.findAllCatBreeds();
		return breeds.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CatBreedDTO> getCatBreedById(@PathVariable Long id) {
		return catBreedService.findCatBreedById(id).map(this::convertToDTO).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public CatBreedDTO addCatBreed(@RequestBody CatBreedDTO catBreedDTO) {
		CatBreed catBreed = convertToEntity(catBreedDTO);
		CatBreed savedCatBreed = catBreedService.saveCatBreed(catBreed);
		return convertToDTO(savedCatBreed);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCatBreed(@PathVariable Long id) {
		catBreedService.deleteCatBreed(id);
		return ResponseEntity.ok().build();
	}

	private CatBreedDTO convertToDTO(CatBreed catBreed) {
		CatBreedDTO dto = new CatBreedDTO();
		dto.setId(catBreed.getId());
		dto.setName(catBreed.getName());
		dto.setOrigin(catBreed.getOrigin());
		dto.setDescription(catBreed.getDescription());
		// Altre conversioni se necessario
		return dto;
	}

	private CatBreed convertToEntity(CatBreedDTO catBreedDTO) {
		CatBreed catBreed = new CatBreed();
		catBreed.setName(catBreedDTO.getName());
		catBreed.setOrigin(catBreedDTO.getOrigin());
		catBreed.setDescription(catBreedDTO.getDescription());
		// Altre conversioni se necessario
		return catBreed;
	}
}
