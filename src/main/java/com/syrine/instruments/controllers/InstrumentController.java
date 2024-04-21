package com.syrine.instruments.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.syrine.instruments.entities.Instrument;
import com.syrine.instruments.service.InstrumentService;

@Controller
public class InstrumentController {
	@Autowired
	InstrumentService instrumentService;

	@RequestMapping("/ListeInstruments")
	public String listeInstruments(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Instrument> instr = instrumentService.getAllInstrumentsParPage(page, size);
		modelMap.addAttribute("instruments", instr);
		modelMap.addAttribute("pages", new int[instr.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeInstruments";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createInstrument";
	}

	@RequestMapping("/saveInstrument")
	public String saveInstrument(@ModelAttribute("instrument") Instrument instrument, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		instrument.setDateCreation(dateCreation);

		Instrument saveInstrument = instrumentService.saveInstrument(instrument);
		String msg = "instrument enregistré avec Id " + saveInstrument.getIdInstrument();
		modelMap.addAttribute("msg", msg);
		return "createInstrument";
	}

	@RequestMapping("/supprimerInstrument")
	public String supprimerInstrument(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		instrumentService.deleteInstrumentById(id);
		Page<Instrument> instr = instrumentService.getAllInstrumentsParPage(page,size);
		modelMap.addAttribute("instruments", instr);
		modelMap.addAttribute("pages", new int[instr.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeInstruments";
	}

	@RequestMapping("/modifierInstrument")
	public String editerInstrument(@RequestParam("id") Long id, ModelMap modelMap) {
		Instrument i = instrumentService.getInstrument(id);
		modelMap.addAttribute("instrument", i);
		return "editerInstrument";
	}

	@RequestMapping("/updateInstrument")
	public String updateInstrument(@ModelAttribute("instrument") Instrument instrument,
			@RequestParam("date") String date, ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		instrument.setDateCreation(dateCreation);

		instrumentService.updateInstrument(instrument);
		List<Instrument> instr = instrumentService.getAllInstruments();
		modelMap.addAttribute("instruments", instr);
		return "listeInstruments";
	}
}