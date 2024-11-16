package com.mvc.productos_crud.controller;

import com.mvc.productos_crud.entity.InstrumentEntity;
import com.mvc.productos_crud.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrumentos")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @GetMapping
    public List<InstrumentEntity> getAllInstruments() {
        return instrumentService.getAllInstruments();
    }

    @PostMapping
    public InstrumentEntity addInstrument(@RequestBody InstrumentEntity instrument) {
        return instrumentService.addInstrument(instrument);
    }

    @PutMapping("/{id}")
    public InstrumentEntity updateInstrument(@PathVariable Long id, @RequestBody InstrumentEntity instrument) {
        return instrumentService.updateInstrument(id, instrument);
    }

    @DeleteMapping("/{id}")
    public void deleteInstrument(@PathVariable Long id) {
        instrumentService.deleteInstrument(id);
    }
}
