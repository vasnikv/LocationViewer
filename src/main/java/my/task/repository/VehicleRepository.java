package my.task.repository;

import my.task.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query(value = "select v from Vehicle v where v.active = true ")
    public List<Vehicle> findAllActive();

}
