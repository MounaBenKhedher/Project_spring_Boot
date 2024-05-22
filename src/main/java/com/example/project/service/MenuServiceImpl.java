package com.example.project.service;

import com.example.project.exception.MissingEntity;
import com.example.project.form.MenuForm;
import com.example.project.model.Menu;
import com.example.project.model.Modul;
import com.example.project.repository.MenuRepository;
import com.example.project.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    ModuleRepository moduleRepository;
    @Override
    public Modul findByCodmodule(String codmodule) throws MissingEntity {
        Optional<Modul> module = moduleRepository.findByCodmodule(codmodule);
        if(!module.isPresent()){
            throw new MissingEntity("Module not found with cod Module : "+codmodule);
        }
        return module.get();
    }
    @Override
    public Menu addMenu(MenuForm form) throws MissingEntity {
        Modul modul =findByCodmodule(form.getCodmodule());
        Menu menu = new Menu();
        menu.setCodmenu(form.getCodMenu());
        menu.setLibmenu(form.getLibMenu());
        menu.setModule(modul);
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu findByCodmenu(String codMenu) throws MissingEntity {
        Optional<Menu> menue = menuRepository.findByCodmenu(codMenu);
        if(!menue.isPresent()){
            throw new MissingEntity("Menue not found with code Menu : "+codMenu);
        }
        return menue.get();
    }

    @Override
    public Menu updateMenu(String codMenu, MenuForm form) throws MissingEntity {
        Menu menu = findByCodmenu(codMenu);
        menu.setCodmenu(form.getCodMenu());
        menu.setLibmenu(form.getLibMenu());
        return menuRepository.save(menu);    }

    @Override
    public Map<String, Boolean> deleteMenu(String codMenu) throws MissingEntity {
        Menu menu = findByCodmenu(codMenu);
        menuRepository.delete(menu);
        Map<String,Boolean> map = new HashMap<>();
        map.put("deleted",Boolean.TRUE);
        return map;
    }
}


