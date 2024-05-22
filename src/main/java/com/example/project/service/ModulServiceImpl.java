package com.example.project.service;

import com.example.project.form.ModulForm;
import com.example.project.model.Modul;
import com.example.project.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ModulServiceImpl implements  ModulService{
    @Autowired
    ModuleRepository moduleRepository;
    @Override
    public List<Modul> getModules() {
        return moduleRepository.findAll();
    }

    @Override
    public Modul addModule(ModulForm form) {
            Modul modul =new Modul();
            modul.setCodmodule(form.getCdModul());
            modul.setLibmodule(form.getLbModul());
            return moduleRepository.save(modul);

    }

    @Override
    public Modul findByCodmodule(String codmodule) {
        Optional<Modul> module = moduleRepository.findByCodmodule(codmodule);
        return module.get();
    }

    @Override
    public Map<String, Boolean> deleteModule(String codmodule){
        Modul modul = findByCodmodule(codmodule);
        moduleRepository.delete(modul);
        Map<String,Boolean> map = new HashMap<>();
        map.put("deleted",Boolean.TRUE);
        return map;
    }

    @Override
    public Modul updateModule(String codmodule, ModulForm form) {
        Modul modul = findByCodmodule(codmodule);
        modul.setCodmodule(form.getCdModul());
        modul.setLibmodule(form.getLbModul());
        return moduleRepository.save(modul);
    }
}
