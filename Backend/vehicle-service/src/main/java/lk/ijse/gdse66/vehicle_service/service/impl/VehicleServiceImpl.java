package lk.ijse.gdse66.vehicle_service.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse66.vehicle_service.dto.VehicleDTO;
import lk.ijse.gdse66.vehicle_service.entity.VehicleEntity;
import lk.ijse.gdse66.vehicle_service.repo.VehicleRepo;
import lk.ijse.gdse66.vehicle_service.service.VehicleService;
import lk.ijse.gdse66.vehicle_service.service.exception.DuplicateRecordException;
import lk.ijse.gdse66.vehicle_service.service.exception.NotFoundException;
import lk.ijse.gdse66.vehicle_service.service.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    Transformer transformer;

    @Autowired
    public RestTemplate restTemplate;

    @Override
    public List<VehicleDTO> getAllVehicles() {

        List<VehicleEntity> Vehicles = vehicleRepo.findAll();

        if (Vehicles.isEmpty()) {
            throw new NotFoundException("No Vehicles Exist");
        }
        return Vehicles.stream().map(VehicleEntity -> transformer.fromVehicleEntity(VehicleEntity)).toList();
    }

    @Override
    public VehicleDTO getVehicleById(String vehicleId) {

        if (!vehicleRepo.existsById(vehicleId)) {
            throw new NotFoundException("Vehicle nic : " + vehicleId + " doesn't exist");
        }
        return transformer.fromVehicleEntity(vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new NotFoundException("Vehicle nic : " + vehicleId + " doesn't exist")));
    }

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {

        if (vehicleRepo.existsById(vehicleDTO.getVehicleId())) {
            throw new DuplicateRecordException("Vehicle id : " + vehicleDTO.getVehicleId() + " already exist");
        }

        Boolean isUserExit = restTemplate.getForObject("http://user-service/user/isExit/" + vehicleDTO.getUserNIC(), Boolean.class);
        if(Boolean.FALSE.equals(isUserExit)){
            throw new NotFoundException("User Nic : "+vehicleDTO.getUserNIC()+" doesn't exist");
        }

        return transformer.fromVehicleEntity(vehicleRepo.save(transformer.toVehicleEntity(vehicleDTO)));
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleRepo.existsById(vehicleDTO.getVehicleId())) {
            throw new NotFoundException("Vehicle id : " + vehicleDTO.getVehicleId() + " doesn't exist");
        }
        vehicleRepo.save(transformer.toVehicleEntity(vehicleDTO));
    }

    @Override
    public void deleteVehicle(String vehicleId) {
        if (!vehicleRepo.existsById(vehicleId)) {
            throw new NotFoundException("Vehicle id : " + vehicleId + " doesn't exist");
        }
        vehicleRepo.deleteById(vehicleId);
    }

}
