package source_files.dataAccess.userRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import source_files.data.models.UserEntities.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {
}
