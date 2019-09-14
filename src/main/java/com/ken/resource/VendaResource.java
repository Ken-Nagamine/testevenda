/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ken.resource;

import com.ken.entity.Venda;
import com.ken.repository.VendaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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
    
    //consulta uma venda
    @GetMapping("/consultar_venda/{id}")
    public Venda listaVendaUnica(@PathVariable(value="id") long id){
        return vendaRepository.findById(id);
    }
    
    // consulta todas as vendas..
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
    // Para consultar ex: localhost:8080/api/consulta_venda_periodo?data_ini=2019-01-01&data_fim=2019-01-05
    @GetMapping("/consulta_venda_periodo")
    public List<Venda> listaVendaPeriodo(@RequestParam("data_ini") String data_ini, @RequestParam("data_fim") String data_fim){
        
        return vendaRepository.buscarVendaComDataVendaNoIntervalo(data_ini,data_fim);
    }
    
    // Retorna nome, total_vendas e media_diaria em função de um periodo 
    // Para consultar ex: localhost:8080/api/consulta_vendedor_periodo?data_ini=2019-01-01&data_fim=2019-01-05
    @GetMapping("/consulta_vendedor_periodo")
    public ArrayList<Object> listaVendedorPeriodo(@RequestParam("data_ini") String data_ini, @RequestParam("data_fim") String data_fim){
        
        return vendaRepository.buscarVendedorTotalVendasMediaDiaria(data_ini, data_fim);
    }
    
}
