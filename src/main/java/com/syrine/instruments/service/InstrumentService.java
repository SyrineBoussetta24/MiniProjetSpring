package com.syrine.instruments.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.syrine.instruments.entities.Instrument;
import com.syrine.instruments.entities.Type;

public interface InstrumentService {
	Instrument saveInstrument(Instrument i);
	Instrument updateInstrument(Instrument i);
	void deleteInstrument(Instrument i);
	void deleteInstrumentById(Long id);
	Instrument getInstrument(Long id);
	List<Instrument> getAllInstruments();
	List<Instrument> findByNomInstrument(String nom);
	List<Instrument> findByNomInstrumentContains(String nom);
	List<Instrument> findByNomPrix (String nom, Double prix);
	List<Instrument> findByType (Type type);
	List<Instrument> findByTypeIdTyp(Long id);
	List<Instrument> findByOrderByNomInstrumentAsc();
	List<Instrument> trierInstrumentsNomsPrix();
	Page<Instrument> getAllInstrumentsParPage(int page, int size);
	
	List<Type> getAllTypes();
}
