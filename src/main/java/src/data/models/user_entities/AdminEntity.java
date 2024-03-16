package src.data.models.user_entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import src.controllers.user.responses.AdminResponse;
import src.data.models.base_entities.UserEntity;

import static src.data.enums.types.user_types.UserRole.ADMIN;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder(builderMethodName = "adminBuilder")
@Table(name = "admins")
public class AdminEntity extends UserEntity {

    @Column(name = "salary")
    private double salary;

    public AdminResponse toModel() {
        return AdminResponse.builder()
                .id(getId())
                .name(getName())
                .surname(getSurname())
                .email(getEmailAddress())
                .phoneNumber(getPhoneNumber())
                .salary(getSalary())
                .salary(getSalary())
                .userImageEntityImageUrl(getUserImageEntity().getUrl())
                .isDeleted(getIsDeleted())
                .authority(getAuthority())
                .build();
    }

    @PrePersist
    protected void beforeCreate() {
        super.beforeCreate();  // BaseEntity sınıfındaki beforeCreate metodu çağırdık.
        this.setAuthority(ADMIN);
    }

    @PreUpdate
    protected void beforeUpdate() {
        super.beforeUpdate();
        this.setAuthority(ADMIN);
    }
}