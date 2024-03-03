package source_files.data.requests.vehicleRequests.VehicleFeaturesRequests.ColorRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import source_files.data.requests.BaseRequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateColorRequest extends BaseRequest {
    @NotNull(message = "Renk null olamaz")
    @NotBlank(message = "Renk adı boş geçilemez")
    @Size(min = 2, message = "Renk en az 2 karakter olmalıdır.")
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ]+$", message = "renk sadece harflerden oluşmalıdır.")
    String colorEntityName;
}