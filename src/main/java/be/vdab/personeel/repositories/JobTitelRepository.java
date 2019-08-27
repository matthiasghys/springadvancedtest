package be.vdab.personeel.repositories;

import be.vdab.personeel.domain.JobTitel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobTitelRepository extends JpaRepository<JobTitel, Long> {
    List<JobTitel> findAll();
    JobTitel findById(long id);
}
