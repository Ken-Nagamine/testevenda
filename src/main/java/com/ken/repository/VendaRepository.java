/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ken.repository;

import com.ken.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ken
 */
public interface VendaRepository extends JpaRepository<Venda, Long>{
    
    Venda findById(long id);
}
