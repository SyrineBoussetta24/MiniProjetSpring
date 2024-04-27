package com.syrine.instruments.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.syrine.instruments.entities.Type;


public interface TypeRepository extends JpaRepository<Type, Long>
{
}