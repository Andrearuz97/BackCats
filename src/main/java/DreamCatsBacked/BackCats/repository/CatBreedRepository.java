package DreamCatsBacked.BackCats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DreamCatsBacked.BackCats.entity.CatBreed;

@Repository
public interface CatBreedRepository extends JpaRepository<CatBreed, Long> {
}
