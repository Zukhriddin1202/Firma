package com.example.firma.Been;

import com.example.firma.Model.Ishchi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IshchiBeen extends JpaRepository<Ishchi,Integer> {
    boolean existsByTelNomerAndFirmaId(String s,Integer id);
    boolean existsByIdNotAndTelNomerAndFirmaId(Integer id, String s,Integer f);
    List<Ishchi> findAllByFirmaId(Integer id);
}
