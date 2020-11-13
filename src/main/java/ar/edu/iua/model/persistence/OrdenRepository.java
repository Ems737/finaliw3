package ar.edu.iua.model.persistence;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ar.edu.iua.model.Orden;
//import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

	Optional<Orden> findByNumeroOrden(int nroOrden);

}
