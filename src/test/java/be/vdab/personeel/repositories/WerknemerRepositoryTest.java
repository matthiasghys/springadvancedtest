package be.vdab.personeel.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql("/insertWerknemer.sql")
public class WerknemerRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private WerknemerRepository repository;
    @Autowired
    private EntityManager entityManager;
    private long idVanTestWerknemer(){
        return  super.jdbcTemplate.queryForObject("select id from werknemers where familienaam = 'test'", Long.class);
    }

    @Test
    public void testWerknemerVindenWerkt(){
        assertThat(repository.findById(idVanTestWerknemer()).get().getFamilienaam()).isEqualTo("test");

    }


}
