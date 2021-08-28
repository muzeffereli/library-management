package az.muzeffereli.library.management.dto;

import az.muzeffereli.library.management.dao.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDto {
    private String location;
    private String library;

    public AddressResponseDto(Address address) {
        this.location= address.getLocation();
        this.library=address.getLibrary().getName();
    }
}

