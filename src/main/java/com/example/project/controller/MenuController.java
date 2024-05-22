package com.example.project.controller;



import com.example.project.dto.Menudto;
import com.example.project.dto.Moduldto;
import com.example.project.exception.MissingEntity;
import com.example.project.form.MenuForm;
import com.example.project.form.ModulForm;
import com.example.project.model.Menu;
import com.example.project.model.Modul;
import com.example.project.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/menu")
@CrossOrigin(origins = "*")
public class MenuController {
    @Autowired
    MenuService menuService ;

    @GetMapping(value="/getMenu")
    List<Menudto> getAll(){
        List<Menu> menus=menuService.getAllMenus();
        return Menudto.of(menus);
    }

    @PostMapping("/addMenu")
    public Menudto addMenu(@RequestBody MenuForm form) throws MissingEntity {
        Menu menu =menuService.addMenu(form);
        return Menudto.of(menu);
    }
    @PutMapping("/updateMenu/{codMenu}")
    public Menudto updateMenu(@PathVariable String codMenu, @RequestBody MenuForm form) throws MissingEntity {
        Menu menu = menuService.updateMenu(codMenu,form);
        return Menudto.of(menu);

    }
    @DeleteMapping(value="/deleteMenu/{codMenu}")
    public Map<String,Boolean> deleteMenu(@PathVariable String codMenu) throws MissingEntity {
        return menuService.deleteMenu(codMenu);
    }
    @GetMapping("/getByCodMenu/{codMenu}")
    public Menudto getMenu(@PathVariable String codMenu) throws MissingEntity{
        Menu menu = menuService.findByCodmenu(codMenu);
        return Menudto.of(menu);
    }

    /// les exception

}
