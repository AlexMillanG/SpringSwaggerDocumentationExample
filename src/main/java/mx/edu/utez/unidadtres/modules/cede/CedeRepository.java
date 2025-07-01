package mx.edu.utez.unidadtres.modules.cede;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CedeRepository extends JpaRepository<CedeEntity,Long> {
}
