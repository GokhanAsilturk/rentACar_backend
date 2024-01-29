package source_files.data.requests.userRequests;

import jakarta.validation.constraints.*;
import lombok.*;
import source_files.data.Status.DefaultUserStatus;
import source_files.data.requests.BaseRequest;
import source_files.data.types.userTypes.UserRole;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateAdminRequest extends BaseRequest {
    @NotNull(message = "isim null olamaz")
    @NotBlank(message = "isim boş geçilemez")
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ\\s]+$", message = "isim/soyisim sadece harflerden oluşmalıdır.")
    @Size(min = 2, max = 20)
    private String name;

    @NotNull(message = "soyisim null olamaz")
    @NotBlank(message = "Soyisim boş geçilemez")
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ\\s]+$", message = "isim/soyisim sadece harflerden oluşmalıdır.")
    private String surname;

    @Email//-> Email alırken @gmail @hotmail gibi kullanımları denetler.
    @NotNull(message = "Admin mail adresi null olamaz")
    @NotBlank(message = "Admin mail adresi boş geçilemez")
    private String emailAddress;

    @Size(min = 8, max = 30)
    @NotNull(message = "Şifre null olamaz")
    @NotBlank(message = "Şifre boş geçilemez")
    private String password;

    @NotNull(message = "telefon numarası null olamaz")
    @Size(min = 10, max = 10, message = "Telefon numarası 10 hane olmalıdır.")
    @Pattern(regexp = "^[0-9]+$", message = "Telefon numarası sadece sayılardan oluşmalıdır.")
    private String phoneNumber;

    @NotNull(message = "maaş null olamaz")
    @NotBlank(message = "maaş boş geçilemez")
    @Min(0)
    private Double salary;

    private String imagePath;
    private UserRole authority = UserRole.ADMIN;
}
