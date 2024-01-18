package ru.sberbank.jd.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.jd.entity.Client;
import ru.sberbank.jd.repository.ClientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    @Transactional
    public List<Client> getAllClients() {
//        clientRepository.findClientsByFirstNameAndLastName();
        return clientRepository.findAll();
    }
}
