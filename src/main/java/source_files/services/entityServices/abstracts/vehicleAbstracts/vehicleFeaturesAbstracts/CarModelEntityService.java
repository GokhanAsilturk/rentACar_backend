package source_files.services.entityServices.abstracts.vehicleAbstracts.vehicleFeaturesAbstracts;

import source_files.controllers.vehicle.requests.VehicleFeaturesRequests.CarModelRequests.CreateCarModelRequest;
import source_files.controllers.vehicle.requests.VehicleFeaturesRequests.CarModelRequests.UpdateCarModelRequest;
import source_files.data.models.vehicleEntities.vehicleFeatures.CarFeatures.CarModelEntity;

import java.util.List;

public interface CarModelEntityService {
    CarModelEntity create(CreateCarModelRequest createCarModelRequest);

    CarModelEntity update(UpdateCarModelRequest updateCarModelRequest);

    CarModelEntity update(CarModelEntity carModelEntity);

    CarModelEntity getById(int id);

    CarModelEntity getByModelName(String modelName);

    List<CarModelEntity> getAll();

    List<CarModelEntity> getAllByDeletedState(boolean isDeleted);

    List<CarModelEntity> getAllByBrandId(int id);

    void delete(CarModelEntity carModelEntity);
}




