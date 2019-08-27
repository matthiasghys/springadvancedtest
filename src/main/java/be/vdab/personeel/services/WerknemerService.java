package be.vdab.personeel.services;

import be.vdab.personeel.domain.Werknemer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface WerknemerService {
    Werknemer findByChefIsNull();
    List<Werknemer> findAll();
    List<Werknemer> findByChef(long id);
    Werknemer findById(long id);
    void opslagDatabank(Werknemer werknemer);
}
