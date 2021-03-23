package demo_jwt.demo.repository;

import demo_jwt.demo.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRepo extends CrudRepository<AppUser,Long> {
    AppUser findAppUserByUsername(String name);
}