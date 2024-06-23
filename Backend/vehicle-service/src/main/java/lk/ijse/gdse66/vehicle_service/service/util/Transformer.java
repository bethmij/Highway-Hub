package lk.ijse.gdse66.vehicle_service.service.util;

import lk.ijse.gdse66.vehicle_service.dto.VehicleDTO;
import lk.ijse.gdse66.vehicle_service.entity.VehicleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

    private final ModelMapper mapper;

    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public VehicleDTO fromVehicleEntity(VehicleEntity VehicleEntity) {
        return mapper.map(VehicleEntity, VehicleDTO.class);
    }

    public VehicleEntity toVehicleEntity(VehicleDTO VehicleDTO) {
        return mapper.map(VehicleDTO, VehicleEntity.class);
    }



}
