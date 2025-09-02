package com.empirico.repository;

import com.empirico.Model.Mantenimiento;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MantenimientoRepository {
    private List<Mantenimiento> mantenimientos = new ArrayList<>();
    private long idCounter = 1;

    public List<Mantenimiento> findAll() { return mantenimientos; }

    public Mantenimiento findById(Long id) {
        Optional<Mantenimiento> result = mantenimientos.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
        return result.orElse(null);
    }

    public void save(Mantenimiento m) {
        m.setId(idCounter++);
        mantenimientos.add(m);
    }

    public void update(Mantenimiento m) {
        for (int i = 0; i < mantenimientos.size(); i++) {
            if (mantenimientos.get(i).getId().equals(m.getId())) {
                mantenimientos.set(i, m);
                return;
            }
        }
    }

    public void delete(Long id) { mantenimientos.removeIf(m -> m.getId().equals(id)); }
}
