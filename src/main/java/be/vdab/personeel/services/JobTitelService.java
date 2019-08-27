package be.vdab.personeel.services;

import be.vdab.personeel.domain.JobTitel;

import java.util.List;

public interface JobTitelService {

    List<JobTitel> findAll();
    JobTitel findById(long id);
}
