package lk.ijse.gdse66.vehicle_service.api;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.MediaType;
import lk.ijse.gdse66.vehicle_service.dto.VehicleDTO;
import lk.ijse.gdse66.vehicle_service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {


    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON)
    public List<VehicleDTO> getAllVehicle() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping(path = "/{vehicleId}", produces = MediaType.APPLICATION_JSON)
    public VehicleDTO getVehicleByID(@PathVariable("vehicleId") String vehicleId) {
        return vehicleService.getVehicleById(vehicleId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleDTO saveVehicle(@Valid @RequestBody VehicleDTO vehicleDTO){
        return vehicleService.saveVehicle(vehicleDTO);
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateVehicle(@Valid @RequestBody VehicleDTO vehicleDTO){
        vehicleService.updateVehicle(vehicleDTO);
    }

    @DeleteMapping(path = "/{vehicleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable("vehicleId") String vehicleId){
        vehicleService.deleteVehicle(vehicleId);
    }
}
