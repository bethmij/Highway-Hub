package lk.ijse.gdse66.vehicle_service.repo;

import lk.ijse.gdse66.vehicle_service.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<VehicleEntity, String> {

    Boolean existsByUserNIC(String userId);
}
