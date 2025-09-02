package com.empirico.repository;

import com.empirico.Model.Equipo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EquipoRepository {
    private List<Equipo> equipos = new ArrayList<>();
    private long idCounter = 1;

    public List<Equipo> findAll() { return equipos; }

    public Equipo findById(Long id) {
        Optional<Equipo> result = equipos.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
        return result.orElse(null);
    }

    public void save(Equipo equipo) {
        equipo.setId(idCounter++);
        equipos.add(equipo);
    }

    public void update(Equipo equipo) {
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getId().equals(equipo.getId())) {
                equipos.set(i, equipo);
                return;
            }
        }
    }

    public void delete(Long id) { equipos.removeIf(e -> e.getId().equals(id)); }
}
