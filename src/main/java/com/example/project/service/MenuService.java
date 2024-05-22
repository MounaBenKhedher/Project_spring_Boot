package com.example.project.service;

import com.example.project.exception.MissingEntity;
import com.example.project.form.MenuForm;
import com.example.project.form.ModulForm;
import com.example.project.model.Menu;
import com.example.project.model.Modul;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface MenuService {
    Modul findByCodmodule(String codmodule) throws MissingEntity;

    public Menu addMenu(MenuForm form) throws MissingEntity;
    public List<Menu> getAllMenus();
    public Menu findByCodmenu(String codMenu) throws MissingEntity;
    public Menu updateMenu(String codMenu, MenuForm form) throws MissingEntity;
    public Map<String,Boolean> deleteMenu(String codMenu) throws MissingEntity;


}
