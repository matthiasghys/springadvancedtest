package be.vdab.personeel.services;

import be.vdab.personeel.domain.Werknemer;

import java.util.List;
import java.util.Optional;

public interface WerknemerService {
    Werknemer findByChefIsNull();
    List<Werknemer> findAll();
    List<Werknemer> findByChef(long id);
}
