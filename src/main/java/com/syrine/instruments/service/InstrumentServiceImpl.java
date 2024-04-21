package com.syrine.instruments.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.syrine.instruments.entities.Instrument;
import com.syrine.instruments.repos.InstrumentRepository;

@Service
public class InstrumentServiceImpl implements InstrumentService {
	@Autowired
	InstrumentRepository instrumentRepository;

	@Override
	public Instrument saveInstrument(Instrument i) {
		return instrumentRepository.save(i);
	}

	@Override
	public Instrument updateInstrument(Instrument i) {
		return instrumentRepository.save(i);
	}

	@Override
	public void deleteInstrument(Instrument i) {
		instrumentRepository.delete(i);
	}

	@Override
	public void deleteInstrumentById(Long id) {
		instrumentRepository.deleteById(id);
	}

	@Override
	public Instrument getInstrument(Long id) {
		return instrumentRepository.findById(id).get();
	}

	@Override
	public List<Instrument> getAllInstruments() {
		return instrumentRepository.findAll();
	}

	@Override
	public Page<Instrument> getAllInstrumentsParPage(int page, int size) {
		return instrumentRepository.findAll(PageRequest.of(page, size));
	}
}
