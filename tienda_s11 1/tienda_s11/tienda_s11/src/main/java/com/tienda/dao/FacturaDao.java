/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.dao;

import com.tienda.domain.Factura;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Ariana
 */
public interface FacturaDao extends JpaRepository<Factura, Long>{
      @Query(value = "SELECT * FROM factura a WHERE a.fecha BETWEEN :fechaInicio AND :fechaFin  ORDER BY a.fecha",
           nativeQuery = true)
    List<Factura> findTotalVentasByFechaRange(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
}
