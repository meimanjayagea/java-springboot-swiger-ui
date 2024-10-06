package co.demo.app.models.repository;

import co.demo.app.models.entity.Users;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends ListCrudRepository<Users, Integer> {}
