package ru.basanov.apponlinestore.repository.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.basanov.apponlinestore.model.user.Role;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

}
