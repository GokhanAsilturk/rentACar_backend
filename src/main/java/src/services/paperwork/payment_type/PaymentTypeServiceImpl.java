package src.services.paperwork.payment_type;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import src.controllers.paperwork.requests.payment.CreatePaymentTypeRequest;
import src.controllers.paperwork.requests.payment.UpdatePaymentTypeRequest;
import src.controllers.paperwork.responses.PaymentTypeResponse;
import src.data.models.paperwork_entities.paymentEntities.PaymentTypeEntity;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentTypeServiceImpl implements PaymentTypeService {
    private final PaymentTypeEntityService entityService;
    private final PaymentTypeRules rules;

    @Override
    public void create(CreatePaymentTypeRequest createPaymentTypeRequest) {
        createPaymentTypeRequest = rules.fix(createPaymentTypeRequest);
        rules.check(createPaymentTypeRequest);
        entityService.create(createPaymentTypeRequest);
    }

    @Override
    public PaymentTypeResponse update(UpdatePaymentTypeRequest updatePaymentTypeRequest) {
        updatePaymentTypeRequest = rules.fix(updatePaymentTypeRequest);
        rules.check(updatePaymentTypeRequest);
        return entityService.update(updatePaymentTypeRequest).toModel();
    }

    @Override
    public PaymentTypeResponse getById(int id) {
        return entityService.getById(id).toModel();
    }

    @Override
    public void delete(int id, boolean hardDelete) {
        if (hardDelete) {
            entityService.delete(entityService.getById(id));
        } else {
            softDelete(id);
        }
    }

    @Override
    public void softDelete(int id) {
        PaymentTypeEntity paymentTypeEntity = entityService.getById(id);
        paymentTypeEntity.setIsDeleted(true);
        paymentTypeEntity.setActive(false);
        paymentTypeEntity.setDeletedAt(LocalDateTime.now());
        entityService.update(paymentTypeEntity);
    }

    @Override
    public List<PaymentTypeResponse> getAll() {
        return maptoDTOList(entityService.getAll());
    }

    @Override
    public List<PaymentTypeResponse> getAllByDeletedState(boolean isDeleted) {
        return maptoDTOList(entityService.getAllByDeletedState(isDeleted));
    }

    @Override
    public List<PaymentTypeResponse> getAllByActiveState(boolean isActive) {
        return maptoDTOList(entityService.getAllByActiveState(isActive));
    }

    private List<PaymentTypeResponse> maptoDTOList(List<PaymentTypeEntity> payments) {
        rules.checkDataList(payments);
        return payments.stream().map(PaymentTypeEntity::toModel).toList();
    }


}