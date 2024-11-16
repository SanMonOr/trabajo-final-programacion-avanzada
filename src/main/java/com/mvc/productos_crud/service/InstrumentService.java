package com.mvc.productos_crud.service;

import com.mvc.productos_crud.entity.InstrumentEntity;
import com.mvc.productos_crud.repositories.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrumentService {

    @Autowired
    private InstrumentRepository instrumentRepository;

    public List<InstrumentEntity> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    public InstrumentEntity addInstrument(InstrumentEntity instrument) {
        return instrumentRepository.save(instrument);
    }

    public InstrumentEntity updateInstrument(Long id, InstrumentEntity instrument) {
        Optional<InstrumentEntity> existingInstrument = instrumentRepository.findById(id);
        if (existingInstrument.isPresent()) {
            instrument.setId(id);
            return instrumentRepository.save(instrument);
        }
        return null;
    }

    public void deleteInstrument(Long id) {
        instrumentRepository.deleteById(id);
    }
}
