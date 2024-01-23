package source_files.data.requests.paperworkRequests.paymentRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import source_files.data.types.itemTypes.PaymentType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentTypeRequest {
    @NotBlank(message = "id boş geçilemez")
    @NotNull
    private int paymentTypeEntityId;
    @NotBlank(message = "Ödeme tipi boş geçilemez")
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ]+$", message = "Ödeme tipi sadece harflerden oluşmalıdır.")
    private String paymentTypeEntityName;
    private PaymentType PaymentTypeEntityPaymentType;
}
