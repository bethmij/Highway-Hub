package lk.ijse.gdse66.vehicle_service.service;


import lk.ijse.gdse66.vehicle_service.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    List<VehicleDTO> getAllVehicles();

    VehicleDTO getVehicleById(String vehicleId);

    VehicleDTO saveVehicle (VehicleDTO vehicleDTO);

    void updateVehicle(VehicleDTO vehicleDTO);

    void deleteVehicle(String vehicleId);
}
