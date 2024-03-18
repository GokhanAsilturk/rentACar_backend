package src.service.user.customer;

import src.controller.rental.responses.RentalResponse;
import src.controller.user.customer.requests.CreateCustomerRequest;
import src.controller.user.customer.requests.UpdateCustomerRequest;
import src.controller.user.customer.responses.CustomerResponse;
import src.repository.rental.RentalEntity;

import java.util.List;

public interface CustomerService {

    void create(CreateCustomerRequest createCustomerRequest);

    CustomerResponse update(UpdateCustomerRequest updateCustomerRequest);

    CustomerResponse getById(int id);

    CustomerResponse getByEmailAddress(String emailAddress);

    List<CustomerResponse> getAll();

    List<CustomerResponse> getAllByDeletedState(boolean isDeleted);

    void addRental(int customerId, RentalEntity rentalEntity);

    void removeRental(int customerId, RentalEntity rentalEntity);

    void delete(int id, boolean hardDelete);

    List<RentalResponse> getRentalHistory(int customerId);

    void softDelete(int id);

    int getCountByDeletedState(boolean isDeleted);

    int getCountByStatus(String status);
}
