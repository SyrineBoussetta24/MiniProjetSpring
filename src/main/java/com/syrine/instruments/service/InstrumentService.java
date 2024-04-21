package com.syrine.instruments.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.syrine.instruments.entities.Instrument;

public interface InstrumentService {
	Instrument saveInstrument(Instrument p);
	Instrument updateInstrument(Instrument p);
	void deleteInstrument(Instrument p);
	 void deleteInstrumentById(Long id);
	 Instrument getInstrument(Long id);
	List<Instrument> getAllInstruments();
	
	Page<Instrument> getAllInstrumentsParPage(int page, int size);
}
