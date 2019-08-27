package be.vdab.personeel.services;

import be.vdab.personeel.domain.JobTitel;
import be.vdab.personeel.repositories.JobTitelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class DefaultJobTitelService implements JobTitelService {

    private final JobTitelRepository repository;

    public DefaultJobTitelService(JobTitelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<JobTitel> findAll() {
        return repository.findAll();
    }

    @Override
    public JobTitel findById(long id) {
        return repository.findById(id);
    }
}
