package com.example.project.controller;

import com.example.project.dto.Moduldto;
import com.example.project.form.ModulForm;
import com.example.project.model.Modul;
import com.example.project.service.ModulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class ModuleController {
    @Autowired
    ModulService modulService;

    @GetMapping(value="/getmodule")
    List<Moduldto> getAll(){
        List<Modul> moduls=modulService.getModules();
        return Moduldto.of(moduls);
    }

    @PostMapping(value="/addModule")
    public Moduldto addModule(@Valid @RequestBody ModulForm form) {
        Modul modul = modulService.addModule(form);
        return  Moduldto.of(modul);
    }
    @PutMapping("/updateModule/{codmodule}")
    public Moduldto updateModul(@PathVariable String codmodule, @RequestBody ModulForm form) {
        Modul modul = modulService.updateModule(codmodule,form);
        return Moduldto.of(modul);

    }
    @DeleteMapping(value="/delete/{codmodule}")
    public Map<String,Boolean> deleteModule(@PathVariable String codmodule){
        return modulService.deleteModule(codmodule);
    }
    @GetMapping("/Module/{cdModul}")
    public Moduldto getModul(@PathVariable String codmodule){
        Modul modul = modulService.findByCodmodule(codmodule);
        return Moduldto.of(modul);
    }

}
