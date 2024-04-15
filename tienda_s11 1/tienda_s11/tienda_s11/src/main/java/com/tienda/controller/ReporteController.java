/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.service.ReporteService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Ariana
 */
@Controller
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    ReporteService reporteService;

    @GetMapping("/principal")
    public String principal(Model model) {
        return "/reportes/principal";
    }

    @GetMapping("/usuarios")
    public ResponseEntity<Resource> usuarios(
            @RequestParam String tipo) throws IOException {
        return reporteService.generaReporte("usuarios", null, tipo);
    }

    @GetMapping("/venta")
    public ResponseEntity<Resource> venta(
            @RequestParam String tipo) throws IOException {
        return reporteService.generaReporte("venta", null, tipo);
    }

    @GetMapping("/ventasTotales")
    public ResponseEntity<Resource> ventasTotales(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam("tipo") String tipo) throws IOException {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("fechaInicio", fechaInicio);
        parametros.put("fechaFin", fechaFin);

        return reporteService.generaReporte("ventasTotales", parametros, tipo);
    }
}
