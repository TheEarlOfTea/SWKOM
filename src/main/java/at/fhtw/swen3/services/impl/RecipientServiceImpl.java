package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.RecipientService;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipientServiceImpl implements RecipientService {
    @Autowired
    private RecipientRepository repository;

    @Override
    public RecipientEntity saveRecipient(Recipient recipient) {

        RecipientEntity oldRecipient= findRecipient(recipient);
        if(oldRecipient==null){
            return repository.save(RecipientMapper.INSTANCE.fromDTO(recipient));

        }
        System.out.println("recipient exists");
        return oldRecipient;



    }


    @Override
    public List<Recipient> findAllRecipients() {
        List<RecipientEntity> list=repository.findAll();
        LinkedList<Recipient> returnList= new LinkedList<Recipient>();
        for(RecipientEntity e: list){
            returnList.add(RecipientMapper.INSTANCE.fromEntity(e));
        }
        return returnList;
    }

    @Override
    public void deleteRecipientById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Recipient getRecipientById(long id) {
        Optional<RecipientEntity> entity= repository.findById(id);
        if(entity.isPresent()){
            return RecipientMapper.INSTANCE.fromEntity(entity.get());
        }
        return null;
    }

    @Override
    public RecipientEntity findRecipient(Recipient recipient) {
        ExampleMatcher matcher= ExampleMatcher.matching().withIgnorePaths("id");
        Optional<RecipientEntity> entity=repository.findOne(Example.of(RecipientMapper.INSTANCE.fromDTO(recipient), matcher));
        if(entity.isPresent()){
            return entity.get();
        }
        return null;
    }
}
