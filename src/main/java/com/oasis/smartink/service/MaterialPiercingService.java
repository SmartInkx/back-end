package com.oasis.smartink.service;

import com.oasis.smartink.model.AgendamentoPiercing;
import com.oasis.smartink.model.MaterialPiercing;
import com.oasis.smartink.repository.MaterialPiercingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MaterialPiercingService {

    @Autowired
    MaterialPiercingRepository materialPiercingRepository;

    public MaterialPiercing save(MaterialPiercing materialPiercing){
        try {
            return uploadMaterialPiercing(materialPiercing);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MaterialPiercing> getAll(){
        try {
            return getMaterialPiercing();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private MaterialPiercing uploadMaterialPiercing(MaterialPiercing materialPiercing) throws Exception {

        String tipo = materialPiercing.getTipo();
        Double valor = materialPiercing.getValor();

        MaterialPiercing buildMaterialPiercing = materialPiercingRepository.saveAndFlush(new MaterialPiercing(tipo, valor));

        return buildMaterialPiercing;
    }

    private List<MaterialPiercing> getMaterialPiercing(){

        List<MaterialPiercing> materialPiercing = materialPiercingRepository.findAll();

        return materialPiercing;
    }
}
