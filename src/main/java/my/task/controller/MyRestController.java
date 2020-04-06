package my.task.controller;

import my.task.entity.Coord;
import my.task.entity.Vehicle;
import my.task.repository.CoordRepository;
import my.task.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.data.domain.*;

@RestController
public class MyRestController {

    // глубина маршрута в часах
    private static final int DEPTHINHOURS = 2;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    CoordRepository coordRepository;

    /*
     * весь транспорт
     */
    @RequestMapping(value = "/vehicles")
    public List<Vehicle> getVehicles() {

        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles;
    }

    /*
     * весь активный транспорт с последними координатами
     */
    @RequestMapping(value = "/activeVehicles")
    public List<Vehicle> getActiveVehicles() {

        List<Vehicle> vehicles = vehicleRepository.findAllActive();
        org.springframework.data.domain.Pageable pageable = PageRequest.of(0, 1, Sort.by("id").descending());
        vehicles.forEach(v -> {
            v.getCoords().add(coordRepository.findLastCoord(v.getId(), pageable).stream().findFirst().orElse(null));
        });
        return vehicles;
    }

    /*
     * транспорт с маршрутом от точки минус N часов до последней точки
     */
    @RequestMapping(value = "/vehicle/{id}")
    public Vehicle getVehicle(@PathVariable("id") Long id) {

        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        org.springframework.data.domain.Pageable pageable = PageRequest.of(0, 1, Sort.by("id").descending());
        Coord coord = coordRepository.findLastCoord(id, pageable).stream().findFirst().orElse(null);
        List<Coord> coords = coordRepository.getRouteByVehicle(id, coord.getId(), 4);
        vehicle.setCoords(coords);
        return vehicle;
    }

    /*
     * транспорт с маршрутом от точки минус N часов до координат маркера
     */
    @RequestMapping(value = "/vehicle/{vehicleId}/coord/{coordId}")
    public Vehicle getVehicleRoute(@PathVariable("vehicleId") Long vehicleId, @PathVariable("coordId") Long coordId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        List<Coord> coords = coordRepository.getRouteByVehicle(vehicleId, coordId, DEPTHINHOURS);
        vehicle.setCoords(coords);
        return vehicle;
    }
}