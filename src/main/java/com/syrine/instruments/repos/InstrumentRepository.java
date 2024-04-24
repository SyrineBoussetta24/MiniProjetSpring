package com.syrine.instruments.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.syrine.instruments.entities.Instrument;
import com.syrine.instruments.entities.Type;

@RepositoryRestResource(path = "rest")
public interface InstrumentRepository extends JpaRepository<Instrument, Long>{
	
	List<Instrument> findByNomInstrument(String nom);
	 List<Instrument> findByNomInstrumentContains(String nom);
	 
		/*
		 * @Query("select i from Instrument i where i.nomInstrument like %?1 and i.prixInstrument > ?2"
		 * ) List<Instrument> findByNomPrix (String nom, Double prix);
		 */
	 
	 @Query("select i from Instrument i where i.nomInstrument like %:nom and i.prixInstrument > :prix")
	 List<Instrument> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 
	 @Query("select i from Instrument i where i.type = ?1")
	 List<Instrument> findByType (Type type);
	 
	 List<Instrument> findByTypeIdTyp(Long id);
	 
	 List<Instrument> findByOrderByNomInstrumentAsc();
	 
	 @Query("select i from Instrument i order by i.nomInstrument ASC, i.prixInstrument DESC")
	 List<Instrument> trierInstrumentsNomsPrix ();

}
