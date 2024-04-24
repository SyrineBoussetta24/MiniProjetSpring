package com.syrine.instruments;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.syrine.instruments.entities.Instrument;
import com.syrine.instruments.entities.Type;
import com.syrine.instruments.repos.InstrumentRepository;
import com.syrine.instruments.service.InstrumentService;

@SpringBootTest
class InstrumentProjectApplicationTests {

	@Autowired
	private InstrumentRepository instrumentRepository;
	
	@Autowired
	private InstrumentService instrumentService;

	@Test
	public void testCreateInstrument() {
		Instrument instr = new Instrument("luth",2200.500,new Date());
	instrumentRepository.save(instr);
	}
	@Test
	public void testFindInstrument()
	{
		Instrument i = instrumentRepository.findById(1L).get();
	System.out.println(i);
	}
	@Test
	public void testUpdateInstrument()
	{
		Instrument i = instrumentRepository.findById(1L).get();
	i.setPrixInstrument(1000.0);
	instrumentRepository.save(i);
	}
	@Test
	public void testDeleteInstrument()
	{
		instrumentRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousInstruments()
	{
	List<Instrument> instr = instrumentRepository.findAll();
	for (Instrument i : instr)
	{
	System.out.println(i);
	}
	}

	/*
	 * @Test public void testFindByNomProduitContains() { Page<Instrument> instr =
	 * instrumentService.getAllInstrumentsParPage(0,2);
	 * System.out.println(instr.getSize());
	 * System.out.println(instr.getTotalElements());
	 * System.out.println(instr.getTotalPages()); instr.getContent().forEach(i ->
	 * {System.out.println(i.toString()); });
	 */
	/*ou bien
	for (Instrument i : instr)
	{
	System.out.println(i);
	} 
	}*/
	@Test
	public void testFindByNomInstrument()
	{
	List<Instrument> instr = instrumentRepository.findByNomInstrument("violon");
	for (Instrument i : instr)
	{
	System.out.println(i);
	}
	}
	
	@Test
	public void testFindByNomInstrumentContains ()
	{
	List<Instrument> instr=instrumentRepository.findByNomInstrumentContains("luth");
	for (Instrument i : instr)
	{
	System.out.println(i);
	} }

	@Test
	public void testfindByNomPrix()
	{
	List<Instrument> instr = instrumentRepository.findByNomPrix("violon", 2200.5);
	for (Instrument i : instr)
	{
	System.out.println(i);
	}
	}
	
	@Test
	public void testfindByType()
	{
	Type typ = new Type();
	typ.setIdTyp(1L);
	List<Instrument> instr = instrumentRepository.findByType(typ);
	for (Instrument i : instr)
	{
	System.out.println(i);
	}
	}
	
	@Test
	public void findByTypeIdTyp()
	{
	List<Instrument> instr = instrumentRepository.findByTypeIdTyp(1L);
	for (Instrument i : instr)
	{
	System.out.println(i);
	}
	 }
	
	@Test
	public void testfindByOrderByNomInstrumentAsc()
	{
	List<Instrument> instr =
			instrumentRepository.findByOrderByNomInstrumentAsc();
	for (Instrument i : instr)
	{
	System.out.println(i);
	}
	}
	
	@Test
	public void testTrierInstrumentsNomsPrix()
	{
	List<Instrument> instr = instrumentRepository.trierInstrumentsNomsPrix();
	for (Instrument i : instr)
	{
	System.out.println(i);
	}
	}

}
