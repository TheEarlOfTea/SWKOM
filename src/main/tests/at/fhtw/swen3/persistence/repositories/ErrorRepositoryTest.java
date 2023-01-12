package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.services.dto.Error;
import at.fhtw.swen3.services.mapper.ErrorMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ErrorRepositoryTest {

    @Autowired
    ErrorRepository repository;


    @Test
    public void testDb() {

        ErrorEntity entity= repository.save(ErrorMapper.INSTANCE.fromDTO(new Error().errorMessage("test")));

        Optional<ErrorEntity> optionalErrorEntity= repository.findById(entity.getId());

        assert(optionalErrorEntity.isPresent());

        repository.delete(entity);
    }
}