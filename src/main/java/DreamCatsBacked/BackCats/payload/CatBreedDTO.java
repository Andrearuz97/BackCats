package DreamCatsBacked.BackCats.payload;

import lombok.Data;

@Data
public class CatBreedDTO {
	private Long id;
	private String name;
	private String origin;
	private String description;
	private String idealClimate;
	private String idealFood;
}
