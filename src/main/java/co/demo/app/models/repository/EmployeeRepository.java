package co.demo.app.models.repository;

import co.demo.app.models.entity.Employees;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ListCrudRepository<Employees, Integer> {}
