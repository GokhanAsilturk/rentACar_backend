package source_files.dataAccess.paperWorkRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import source_files.data.models.paperWorkEntities.paymentEntities.DiscountCodeEntity;

import java.util.Optional;

public interface DiscountCodeRepository extends JpaRepository<DiscountCodeEntity, Integer> {

    boolean existsByDiscountCode(String code);

    boolean existsById(int id);


    Optional<DiscountCodeEntity> findByDiscountCode(String code);

}