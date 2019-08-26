package be.vdab.personeel.services;

import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.repositories.WerknemerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
}
