package be.vdab.personeel.services;

import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.repositories.WerknemerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class DefaultWerknemerService implements WerknemerService {

    private final WerknemerRepository repository;

    public DefaultWerknemerService(WerknemerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Werknemer findByChefIsNull() {
        return repository.findByChefIsNull();
    }

    @Override
    public List<Werknemer> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Werknemer> findByChef(long id) {
        return repository.findByChef(id);
    }

    @Override
    public Werknemer findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void opslagDatabank(Werknemer werknemer) {
        repository.save(werknemer);
    }
}
