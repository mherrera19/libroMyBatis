/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.libroMyBatis.repository;


import com.example.libroMyBatis.entity.Editorial;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Usuario
 */
@Mapper
public interface EditorialMyBatisRepository {
    @Select("select * from editorial")
    public List<Editorial> findAll();
    
}
