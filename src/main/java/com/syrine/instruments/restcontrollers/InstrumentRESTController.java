package com.syrine.instruments.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.syrine.instruments.entities.Instrument;
import com.syrine.instruments.service.InstrumentService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class InstrumentRESTController {
	@Autowired
	InstrumentService instrumentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Instrument> getAllInstruments() {
	return instrumentService.getAllInstruments();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Instrument getInstrumentById(@PathVariable("id") Long id) {
	return instrumentService.getInstrument(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public Instrument createInstrument(@RequestBody Instrument instrument) {
	return instrumentService.saveInstrument(instrument);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Instrument updateInstrument(@RequestBody Instrument instrument) {
	return instrumentService.updateInstrument(instrument);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteInstrument(@PathVariable("id") Long id)
	{
		instrumentService.deleteInstrumentById(id);
	}
	
	@RequestMapping(value="/instrtyp/{idTyp}",method = RequestMethod.GET)
	public List<Instrument> getInstrumentsByTypId(@PathVariable("idTyp") Long idTyp) {
	return instrumentService.findByTypeIdTyp(idTyp);
	}
}
