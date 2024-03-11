package source_files.services.entityServices.abstracts.userAbstract;


import source_files.data.models.userEntities.EmployeeEntity;
import source_files.data.requests.userRequests.CreateEmployeeRequest;
import source_files.data.requests.userRequests.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeEntityService {

    EmployeeEntity create(CreateEmployeeRequest createEmployeeRequest);

    EmployeeEntity update(UpdateEmployeeRequest updateEmployeeRequest);

    EmployeeEntity update(EmployeeEntity employeeEntity);

    EmployeeEntity getById(int id);

    EmployeeEntity getByPhoneNumber(String phoneNumber);

    EmployeeEntity getByEmailAddress(String emailAddress);

    List<EmployeeEntity> getAllBySalaryBetween(double salary1, double salary2);

    List<EmployeeEntity> getAll();

    List<EmployeeEntity> getAllByDeletedState(boolean isDeleted);

    void delete(EmployeeEntity userEntity);

    int getCountByDeletedState(boolean isDeleted);
}
