package com.empirico.service;

import com.empirico.Model.Mantenimiento;
import com.empirico.repository.MantenimientoRepository;
import java.util.List;

public class MantenimientoService {
    private MantenimientoRepository repository = new MantenimientoRepository();

    public List<Mantenimiento> findAll() {
        return repository.findAll();
    }

    public Mantenimiento save(Mantenimiento mantenimiento) {
        return repository.save(mantenimiento);
    }
}
