package source_files.services.vehicleFeaturesServices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import source_files.data.DTO.itemDTOs.BrandDTO;
import source_files.data.models.imageEntities.BrandImageEntity;
import source_files.data.models.vehicleEntities.vehicleFeatures.BrandEntity;
import source_files.data.requests.vehicleRequests.VehicleFeaturesRequests.BrandRequests.CreateBrandRequest;
import source_files.data.requests.vehicleRequests.VehicleFeaturesRequests.BrandRequests.UpdateBrandRequest;
import source_files.services.BusinessRules.vehicleFeaturesBusinessRules.BrandBusinessRules;
import source_files.services.entityServices.abstracts.vehicleAbstracts.vehicleFeaturesAbstracts.BrandEntityService;
import source_files.services.systemServices.ImageServices.BrandImageService;
import source_files.services.vehicleFeaturesServices.abstracts.BrandService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandManager implements BrandService {

    private final BrandEntityService entityService;
    private final BrandBusinessRules rules;
    private final BrandImageService brandImageService;

    @Override
    public void create(CreateBrandRequest createBrandRequest) {
        try {
            createBrandRequest = rules.fixCreateBrandRequest(createBrandRequest);
            rules.checkCreateBrandRequest(createBrandRequest);
            entityService.create(createBrandRequest);
        } catch (Exception e) {
            brandImageService.delete(createBrandRequest.getBrandImageEntityId());
            throw e;
        }
    }

    @Override
    public BrandDTO update(UpdateBrandRequest updateBrandRequest) {
        updateBrandRequest = rules.fixUpdateBrandRequest(updateBrandRequest);
        rules.checkUpdateBrandRequest(updateBrandRequest);
        BrandImageEntity brandImage = entityService.getById(updateBrandRequest.getId()).getBrandImageEntity();

        if (brandImage.getId() != updateBrandRequest.getBrandImageEntityId()) {
            brandImageService.delete(brandImage.getId());
        }
        return entityService.update(updateBrandRequest).toModel();
    }

    @Override
    public BrandDTO getById(int id) {
        return entityService.getById(id).toModel();
    }

    @Override
    public List<BrandDTO> getAll() {
        return mapToDTOList(entityService.getAll());
    }

    @Override
    public List<BrandDTO> getAllByDeletedState(boolean isDeleted) {
        return mapToDTOList(entityService.getAllByDeletedState(isDeleted));
    }

    @Override
    public void delete(int id, boolean hardDelete) {

        if (hardDelete) {
            entityService.delete(entityService.getById(id));
            brandImageService.delete(entityService.getById(id).getBrandImageEntity().getId());
        } else {
            softDelete(id);
        }
    }

    @Override
    public void softDelete(int id) {
        BrandEntity brandEntity = entityService.getById(id);
        brandEntity.setIsDeleted(true);
        brandEntity.setDeletedAt(LocalDateTime.now());
        entityService.update(brandEntity);
    }

    private List<BrandDTO> mapToDTOList(List<BrandEntity> brandEntities) {
        rules.checkDataList(brandEntities);
        return brandEntities.stream().map(BrandEntity::toModel).toList();
    }
}
