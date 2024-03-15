package source_files.services.paperWork.rental;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import source_files.controllers.paperWork.dtos.RentalStatusDTO;
import source_files.core.exception.DataNotFoundException;
import source_files.data.enums.defaultDataEnums.Status.DefaultRentalStatus;
import source_files.data.models.paperWorkEntities.rentalEntities.RentalStatusEntity;
import source_files.repositories.paperWork.RentalStatusRepository;
import source_files.services.BusinessRules.paperWork.PaymentRules;
import source_files.services.paperWork.abstracts.RentalStatusService;

import java.util.List;

import static source_files.core.exception.exceptionTypes.NotFoundExceptionType.RENTAL_STATUS_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class RentalStatusServiceImpl implements RentalStatusService {
    private final RentalStatusRepository repository;
    private final PaymentRules rules;

    @Override
    public RentalStatusEntity create(RentalStatusEntity rentalStatusEntity) {
        rentalStatusEntity.setId(0);
        return repository.save(rentalStatusEntity);
    }

    @Override
    public RentalStatusEntity update(RentalStatusEntity rentalStatusEntity) {
        return repository.save(rentalStatusEntity);
    }

    @Override
    public void delete(RentalStatusEntity rentalStatusEntity) {
        repository.delete(rentalStatusEntity);
    }

    @Override
    public RentalStatusEntity getById(int id) {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException(RENTAL_STATUS_NOT_FOUND));
    }

    @Override
    public RentalStatusEntity getByStatus(DefaultRentalStatus status) {
        return repository.findByStatus(status).orElseThrow(() -> new DataNotFoundException(RENTAL_STATUS_NOT_FOUND));
    }


    @Override
    public List<RentalStatusDTO> getAll() {
        List<RentalStatusEntity> entities = repository.findAll();
        rules.checkDataList(entities);
        return entities.stream().map(RentalStatusEntity::toModel).toList();
    }
}
