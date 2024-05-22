package com.example.project.service;

import com.example.project.form.ModulForm;
import com.example.project.model.Modul;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
@Service

public interface ModulService {
    public List<Modul> getModules();
    public Modul addModule(ModulForm form);
   // public Modul getModul(String codemodule);
    Map<String,Boolean> deleteModule(String codemodule);
    public Modul updateModule(String codmodule, ModulForm form);
    public Modul findByCodmodule(String codmodule);

}
