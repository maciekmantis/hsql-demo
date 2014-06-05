package com.mks.hsqldemo;

import com.mks.hsqldemo.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person, Long> {
}
