package kz.satbayev.onlinestore.model.repository;



import kz.satbayev.onlinestore.model.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long> {
    Roles findByRole(String role);
}
