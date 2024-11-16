package com.mvc.productos_crud.service;

import com.mvc.productos_crud.entity.VentaEntity;
import com.mvc.productos_crud.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<VentaEntity> getAllVentas() {
        return ventaRepository.findAll();
    }

    public VentaEntity addVenta(VentaEntity venta) {
        return ventaRepository.save(venta);
    }

    public VentaEntity updateVenta(Long id, VentaEntity venta) {
        Optional<VentaEntity> existingVenta = ventaRepository.findById(id);
        if (existingVenta.isPresent()) {
            venta.setId(id);
            return ventaRepository.save(venta);
        }
        return null;
    }

    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}
