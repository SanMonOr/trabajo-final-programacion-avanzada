package com.mvc.productos_crud.controller;

import com.mvc.productos_crud.entity.EmpleadoEntity;
import com.mvc.productos_crud.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<EmpleadoEntity> getAllEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    @PostMapping
    public EmpleadoEntity addEmpleado(@RequestBody EmpleadoEntity empleado) {
        return empleadoService.addEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public EmpleadoEntity updateEmpleado(@PathVariable Long id, @RequestBody EmpleadoEntity empleado) {
        return empleadoService.updateEmpleado(id, empleado);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleado(id);
    }
}
