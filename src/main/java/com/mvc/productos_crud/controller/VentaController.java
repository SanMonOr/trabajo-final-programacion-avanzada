package com.mvc.productos_crud.controller;

import com.mvc.productos_crud.entity.VentaEntity;
import com.mvc.productos_crud.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<VentaEntity> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @PostMapping
    public VentaEntity addVenta(@RequestBody VentaEntity venta) {
        return ventaService.addVenta(venta);
    }

    @PutMapping("/{id}")
    public VentaEntity updateVenta(@PathVariable Long id, @RequestBody VentaEntity venta) {
        return ventaService.updateVenta(id, venta);
    }

    @DeleteMapping("/{id}")
    public void deleteVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
    }
}
