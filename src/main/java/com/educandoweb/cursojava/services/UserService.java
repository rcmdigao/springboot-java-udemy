package com.educandoweb.cursojava.services;

import com.educandoweb.cursojava.entities.User;
import com.educandoweb.cursojava.repositories.UserRepository;
import com.educandoweb.cursojava.services.exceptions.DatabaseException;
import com.educandoweb.cursojava.services.exceptions.ResourceNotFoundException;
import com.sun.xml.bind.v2.model.annotation.RuntimeInlineAnnotationReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
            // Erro mais genérico: RuntimeInlineAnnotationReader
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) { // Erro de violacao de intefridade de banco de dados.
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj) {
        try {
            User entity = userRepository.getOne(id); // getOne: Prepara o objeto monitorado e depois ele efetua a operacao no BD
            updateData(entity, obj);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }

    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
