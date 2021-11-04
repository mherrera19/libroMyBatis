/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.libroMyBatis.repository;


import com.example.libroMyBatis.entity.Autor;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Usuario
 */
@Mapper
public interface AutorMyBatisRepository {
    @Select("select * from autor")
    public List<Autor> findAll();
    
}
