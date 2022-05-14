package com.example.firma.Service;

import com.example.firma.Been.FirmaBeen;
import com.example.firma.Model.Firma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FirmaService {

    @Autowired
    FirmaBeen firmaBeen;

    public boolean insert(Firma firma){
        if(firmaBeen.existsByNomi(firma.getNomi()))
            return false;
        Firma firma1=new Firma();
        firma1.setEgasi(firma.getEgasi());
        firma1.setNomi(firma.getNomi());
        firma1.setManzil(firma.getManzil());
        firmaBeen.save(firma1);
        return true;
    }

    public List<Firma> select(){
        return firmaBeen.findAll();
    }

    public String update(Integer id, Firma firma){
        Optional<Firma> optional=firmaBeen.findById(id);
        if(!optional.isPresent())
            return "Bunday firma yo'q";
        boolean b = firmaBeen.existsByIdNotAndNomi(id, firma.getNomi());
        if(b) return "Bunday firma mavjud";

            Firma firma1=optional.get();
            firma1.setEgasi(firma.getEgasi());
            firma1.setNomi(firma.getNomi());
            firma1.setManzil(firma.getManzil());
            firmaBeen.save(firma1);
            return "Muavfaqiyatli yangilandi";
    }

    public boolean delete(Integer id){
        Optional<Firma> optional=firmaBeen.findById(id);
        if(optional.isPresent())
        {
            firmaBeen.deleteById(id);
            return true;
        }
        return false;
    }


}
