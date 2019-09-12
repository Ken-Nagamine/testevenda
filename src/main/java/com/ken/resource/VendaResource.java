/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ken.resource;

import com.ken.entity.Venda;
import com.ken.repository.VendaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ken
 */
@RestController
@RequestMapping("/api")
public class VendaResource {
    
    @Autowired
    VendaRepository vendaRepository;
    
    @GetMapping("/consultar_venda/{id}")
    public Venda listaVendaUnica(@PathVariable(value="id") long id){
        return vendaRepository.findById(id);
    }
    
    @GetMapping("/consultar_vendas")
    public List<Venda> listaVendas(){
        return vendaRepository.findAll();
    }
    
    // Cria uma venda
    @PostMapping("/cadastrar_venda")
    public Venda salvaVenda(@RequestBody Venda venda){
        return vendaRepository.save(venda);
    }
    
    // Retorna as vendas em função de um periodo
    @GetMapping("/consulta_venda_periodo")
    public List<Venda> listaVendaPeriodo(@RequestParam("data_ini") String data_ini, @RequestParam("data_fim") String data_fim){
        
        return vendaRepository.buscarVendaComDataVendaNoIntervalo(data_ini,data_fim);
    }
    
}
