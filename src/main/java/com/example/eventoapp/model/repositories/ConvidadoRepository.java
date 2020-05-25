package com.example.eventoapp.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eventoapp.model.entities.Convidado;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, Long>{

}
