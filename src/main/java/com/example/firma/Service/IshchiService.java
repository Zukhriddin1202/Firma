package com.example.firma.Service;

import com.example.firma.Been.FirmaBeen;
import com.example.firma.Been.IshchiBeen;
import com.example.firma.Dto.IshchiFirma;
import com.example.firma.Model.Firma;
import com.example.firma.Model.Ishchi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IshchiService {

    @Autowired
    IshchiBeen ishchiBeen;

    @Autowired
    FirmaBeen firmaBeen;

    public String insert1(IshchiFirma dto){
        Optional<Firma> optional=firmaBeen.findById(dto.getFirmaId());
        if(!optional.isPresent())
            return "Bunday firma mavjud emas";
        boolean nomer = ishchiBeen.existsByTelNomerAndFirmaId(dto.getTelNomer(), dto.getFirmaId());
        if(nomer)
            return "Bunady ishchi mavjud";
        Ishchi ishchi=new Ishchi();
        ishchi.setIsmi(dto.getIsmi());
        ishchi.setManzil(dto.getManzil());
        ishchi.setTelNomer(dto.getTelNomer());
        ishchi.setLavozim(dto.getLavozim());
        ishchi.setMaosh(dto.getMaosh());
        ishchi.setFirma(optional.get());
        ishchiBeen.save(ishchi);
        return "Muavfaqiyatli joylandi";
    }

    public List<Ishchi> select(Integer id){
        Optional<Firma> optional=firmaBeen.findById(id);
        if(optional.isPresent()){
            return ishchiBeen.findAllByFirmaId(id);
        }
        return null;
    }

    public String update(IshchiFirma dto, Integer id){
        Optional<Ishchi> optional=ishchiBeen.findById(id);
        if(!optional.isPresent())
            return "Bunday ishchi yo'q";
        Optional<Firma> optional1=firmaBeen.findById(dto.getFirmaId());
        if(!optional1.isPresent())
            return "Bunday firma mavjud emas";
        boolean nomer = ishchiBeen.existsByIdNotAndTelNomerAndFirmaId(id, dto.getTelNomer(), dto.getFirmaId());
        if(nomer)
            return "Bunady ishchi mavjud";
        Ishchi ishchi=optional.get();
        ishchi.setIsmi(dto.getIsmi());
        ishchi.setManzil(dto.getManzil());
        ishchi.setTelNomer(dto.getTelNomer());
        ishchi.setLavozim(dto.getLavozim());
        ishchi.setMaosh(dto.getMaosh());
        ishchi.setFirma(optional1.get());
        ishchiBeen.save(ishchi);
        return "Muavfaqiyatli yangilandi";
    }

    public boolean delete(Integer id){
        Optional<Ishchi> optional=ishchiBeen.findById(id);
        if(!optional.isPresent())
            return false;
        ishchiBeen.deleteById(id);
        return true;
    }




}
