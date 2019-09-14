/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ken.repository;

import com.ken.entity.Venda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ken
 */
public interface VendaRepository extends JpaRepository<Venda, Long>{
    
    Venda findById(long id);

    @Query(value="select v.* from venda v where v.data_venda between ?1 and ?2", nativeQuery = true)
    List<Venda> buscarVendaComDataVendaNoIntervalo(String de, String ate);
    
    // retorna nome de vendedor,quant vendas, total vendas e média das vendas.
    @Query(value="SELECT vendedor_nome as vendedor, COUNT(vendedor_id) as qtd_vendas , SUM(valor) as total_vendas, AVG(v.valor) as media_diaria from venda v where v.data_venda between ?1 and ?2 group by vendedor_nome", nativeQuery = true)
    public ArrayList<Object> buscarVendedorTotalVendasMediaDiaria( String data_ini, String data_fim);
   
}
