package fr.wildcodeschool.quetespring2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerDao extends JpaRepository <Beer, Long> {
}
