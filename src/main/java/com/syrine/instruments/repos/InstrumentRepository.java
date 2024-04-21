package com.syrine.instruments.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.syrine.instruments.entities.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long>{

}
