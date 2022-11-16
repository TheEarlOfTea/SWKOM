package io.swagger.services.impl;


import io.swagger.persistence.entities.RecipientEntity;
import io.swagger.persistence.repositories.RecipientRepository;
import io.swagger.services.RecipientService;
import io.swagger.services.dto.Recipient;
import io.swagger.services.mapper.RecipientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.LinkedList;
import java.util.List;

@Service

public class RecipientServiceImpl implements RecipientService {


    @Autowired
    private RecipientRepository  recipientRepository;
    @Autowired
    private RecipientMapper recipientMapper;


    // Save operation
    @Override
    public RecipientEntity saveRecipientEntity(Recipient recipient) {
        return recipientRepository.save(recipientMapper.fromDTO(recipient));
    }


    @Override
    // Read operation
        public List<Recipient> fetchRecipientEntityList() {
        List<Recipient> recipients = new LinkedList<>();
        for (RecipientEntity recipientEntity: recipientRepository.findAll()) {
            recipients.add(recipientMapper.fromEntity(recipientEntity));
        }
        return recipients;
    }

    // Delete operation
    @Override
    public void deleteRecipientEntityById(Long Id){
        recipientRepository.deleteById(Id);
    }


    @Override
    public void getAllRecipientEntity(Recipient recipient) {

    }

    @Override
    public void findRecipientEntityByIdAll(Long recipientId) {

    }



}
