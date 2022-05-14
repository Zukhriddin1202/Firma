package com.example.firma.Been;

import com.example.firma.Model.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmaBeen extends JpaRepository<Firma,Integer> {
   boolean existsByNomi(String s);
   boolean existsByIdNotAndNomi(Integer id, String s);
}
