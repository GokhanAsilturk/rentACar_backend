package source_files.data.models.baseEntities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass //Alt klasların database tablosuna buradaki kolonları eklemek için kullanılır.
//todo: baseentity abstract olacak
//todo: bir logo ekleyebilriz img eklersek manager da yapacağız
//todo: base entity de construction gerek yok
//todo: logopath eklenebilir
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;
    @Column(name = "last_modified")
    private LocalDate lastModified;

    @Column(name = "created_date", updatable = false)
    private LocalDate createdDate;

    @PrePersist //classlar oluşmadan çalısır
    private void beforeCreate() {
        createdDate = LocalDate.now();
    }

    @PreUpdate //classlar oluşmadan çalısır
    private void beforeUpdate() {
        lastModified = LocalDate.now();
    }


}
