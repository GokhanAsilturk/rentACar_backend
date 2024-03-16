package src.services.paperwork.payment_type;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import src.controllers.paperwork.requests.payment.CreatePaymentTypeRequest;
import src.controllers.paperwork.requests.payment.UpdatePaymentTypeRequest;
import src.core.exception.DataNotFoundException;
import src.data.enums.default_data_enums.DefaultPaymentType;
import src.data.models.paperwork_entities.paymentEntities.PaymentTypeEntity;
import src.repositories.paperwork.PaymentTypeEntityRepository;

import java.util.List;

import static src.core.exception.exception_types.NotFoundExceptionType.PAYMENT_TYPE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PaymentypeEntityServiceImpl implements PaymentTypeEntityService {

    private final PaymentTypeEntityRepository repository;

    @Override
    public PaymentTypeEntity create(CreatePaymentTypeRequest createPaymentTypeRequest) {
        PaymentTypeEntity paymentTypeEntity = PaymentTypeEntity.paymentTypeBuilder()
                .name(createPaymentTypeRequest.getPaymentTypeEntityName())
                .paymentType(createPaymentTypeRequest.getPaymentType())
                .isActive(createPaymentTypeRequest.isActive())
                .build();
        return repository.save(paymentTypeEntity);
    }

    @Override
    public PaymentTypeEntity update(UpdatePaymentTypeRequest updatePaymentTypeRequest) {
        PaymentTypeEntity paymentTypeEntity = PaymentTypeEntity.paymentTypeBuilder()
                .id(updatePaymentTypeRequest.getId())
                .name(updatePaymentTypeRequest.getName())
                .isActive(updatePaymentTypeRequest.isActive())
                .build();
        return repository.save(paymentTypeEntity);
    }

    @Override
    public PaymentTypeEntity update(PaymentTypeEntity paymentTypeEntity) {
        return repository.save(paymentTypeEntity);
    }

    @Override
    public void delete(PaymentTypeEntity paymentTypeEntity) {
        repository.delete(paymentTypeEntity);
    }

    @Override
    public PaymentTypeEntity getById(int id) {
        return repository.findById(id).orElseThrow(() ->
                new DataNotFoundException(PAYMENT_TYPE_NOT_FOUND));
    }

    @Override
    public PaymentTypeEntity getByPaymentType(DefaultPaymentType defaultPaymentType) {
        return repository.findByPaymentType(defaultPaymentType);
    }

    @Override
    public List<PaymentTypeEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public List<PaymentTypeEntity> getAllByDeletedState(boolean isDeleted) {
        return repository.findAllByIsDeleted(isDeleted);
    }

    @Override
    public List<PaymentTypeEntity> getAllByActiveState(boolean isActive) {
        return repository.findAllByIsActive(isActive);
    }

}