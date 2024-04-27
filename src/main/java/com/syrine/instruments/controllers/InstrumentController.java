package com.syrine.instruments.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.syrine.instruments.entities.Type;
import com.syrine.instruments.entities.Instrument;
import com.syrine.instruments.service.InstrumentService;

import jakarta.validation.Valid;

@Controller
public class InstrumentController {
	@Autowired
	InstrumentService instrumentService;
	
	
		   @RequestMapping("/ListeInstruments")
			public String listeInstruments(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
										@RequestParam (name="size", defaultValue = "2") int size)
			{
			Page<Instrument> instr = instrumentService.getAllInstrumentsParPage(page, size);
				modelMap.addAttribute("instruments", instr);
		         modelMap.addAttribute("pages", new int[instr.getTotalPages()]);	
				modelMap.addAttribute("currentPage", page);			
				return "listeInstruments";	
			}

		   @RequestMapping("/showCreate")
			public String showCreate(ModelMap modelMap)
			{
				modelMap.addAttribute("instrument", new Instrument());
				List<Type> typs = instrumentService.getAllTypes();
				modelMap.addAttribute("mode", "new");
				modelMap.addAttribute("types", typs);
				return "formInstrument";
			}
		   
		   
			


		   @RequestMapping("/saveInstrument")
			public String saveInstrument(@Valid Instrument instrument, BindingResult bindingResult,
					@RequestParam (name="page",defaultValue = "0") int page,
					@RequestParam (name="size", defaultValue = "2") int size)
			{
				int currentPage;
				boolean isNew = false;
			   if (bindingResult.hasErrors()) return "formInstrument";				  
				
			   if(instrument.getIdInstrument()==null) //ajout
				    isNew=true;
			  			   
			   instrumentService.saveInstrument(instrument);
			  	if (isNew) //ajout
			  	{
			  		Page<Instrument> instr = instrumentService.getAllInstrumentsParPage(page, size);
			  		currentPage = instr.getTotalPages()-1;
			  	}
			  	else //modif
			  		currentPage=page;
			  	
			  	
				//return "formInstrument";
				return ("redirect:/ListeInstruments?page="+currentPage+"&size="+size);
			}


	  @RequestMapping("/supprimerInstrument")
		public String supprimerInstrument(@RequestParam("id") Long id,
				ModelMap modelMap,
				@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
		{

		  instrumentService.deleteInstrumentById(id);
			Page<Instrument> instr = instrumentService.getAllInstrumentsParPage(page, size);
			modelMap.addAttribute("instruments", instr);		
			modelMap.addAttribute("pages", new int[instr.getTotalPages()]);	
			modelMap.addAttribute("currentPage", page);	
			modelMap.addAttribute("size", size);	
			return "listeInstruments";	
		}


	@RequestMapping("/modifierInstrument")
	public String editerInstrument(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		Instrument i = instrumentService.getInstrument(id);
		List<Type> typs = instrumentService.getAllTypes();
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("instrument", i);
		modelMap.addAttribute("types", typs);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		
		return "formInstrument";
	}
	  
	

	@RequestMapping("/updateInstrument")
	public String updateInstrument(@ModelAttribute("instrument") Instrument instrument, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
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