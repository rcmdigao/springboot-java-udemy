package com.educandoweb.cursojava.repositories;

import com.educandoweb.cursojava.entities.Category;
import com.educandoweb.cursojava.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
