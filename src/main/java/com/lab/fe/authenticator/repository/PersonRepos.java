package com.lab.fe.authenticator.repository;

import com.lab.fe.authenticator.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepos extends JpaRepository<Person, String> {
}
