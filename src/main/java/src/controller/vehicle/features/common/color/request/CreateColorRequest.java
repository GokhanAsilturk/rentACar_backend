package src.controller.vehicle.features.common.color.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateColorRequest {

    @NotBlank(message = "Renk adı boş geçilemez")
    @Size(min = 2, message = "Renk en az 2 karakter olmalıdır.")
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ]+$", message = "renk sadece harflerden oluşmalıdır.")
    String colorEntityName;
}
