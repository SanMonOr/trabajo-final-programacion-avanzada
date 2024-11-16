package com.mvc.productos_crud.service;

import com.mvc.productos_crud.entity.EmpleadoEntity;
import com.mvc.productos_crud.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<EmpleadoEntity> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public EmpleadoEntity addEmpleado(EmpleadoEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    public EmpleadoEntity updateEmpleado(Long id, EmpleadoEntity empleado) {
        Optional<EmpleadoEntity> existingEmpleado = empleadoRepository.findById(id);
        if (existingEmpleado.isPresent()) {
            empleado.setId(id);
            return empleadoRepository.save(empleado);
        }
        return null;
    }

    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}
