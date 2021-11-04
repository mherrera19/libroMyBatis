/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.libroMyBatis.controller;


import com.example.libroMyBatis.entity.Autor;
import com.example.libroMyBatis.entity.Editorial;
import com.example.libroMyBatis.entity.Libro;
import com.example.libroMyBatis.repository.AutorMyBatisRepository;
import com.example.libroMyBatis.repository.EditorialMyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.libroMyBatis.repository.LibroMyBatisRepository;

/**
 *
 * @author Usuario
 */
@Controller
public class LibroController {
      

    @Autowired
    private AutorMyBatisRepository autorMyBatisRepository;

    @Autowired
    private LibroMyBatisRepository LibroMyBatisRepository;
    
    @Autowired
    private EditorialMyBatisRepository editorialMyBatisRepository; 

    @RequestMapping("/libs")
    public String libs(Model model) {
        model.addAttribute("libs", LibroMyBatisRepository.findAll());
        return "libro/libs";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("edis", editorialMyBatisRepository.findAll());
        model.addAttribute("auts", autorMyBatisRepository.findAll());
        return "libro/addlib";
    }
    

    @RequestMapping("/libadd")
    public String guardar(@RequestParam String nom_libro, @RequestParam int idautor, @RequestParam int ideditorial,Model model) {
        Libro lib = new Libro();
        lib.setNom_libro(nom_libro);
        lib.setIdautor(idautor);
        lib.setIdeditorial(ideditorial);
        return "redirect:/libs";
    }
    @RequestMapping("/dellib/{id}")
    public String deleteprod(@PathVariable(value="id") int id) {
        LibroMyBatisRepository.deleteById(id);
        return "redirect:/libs";
    }
    @RequestMapping("/editlib/{id}")
    public String edit(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("lib", LibroMyBatisRepository.readLibro(id));
        model.addAttribute("auts", autorMyBatisRepository.findAll());
        model.addAttribute("edis", editorialMyBatisRepository.findAll());
        return "libro/editlib";
    }
    @RequestMapping("/updatelib")
    public String update(@RequestParam int id, @RequestParam String nombre, 
             @RequestParam int idautor, @RequestParam int ideditorial) {
        System.out.println(id+"/"+nombre+"/"+idautor+"/"+ideditorial);
        Libro lib = LibroMyBatisRepository.readLibro(id);
        lib.setNom_libro(nombre);
        lib.setIdautor(idautor);
        lib.setIdeditorial(ideditorial);
        LibroMyBatisRepository.update(lib);
        return "redirect:/libs";
    }
}
    
    

