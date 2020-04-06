package my.task.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    private Long id;

    @Column
    private Long driverId;

    @Column
    private String color;

    @Column
    private String model;

    @Column
    private String regNumber;

    @Column
    private Boolean active;

    @Basic(fetch=FetchType.LAZY)
    @OneToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Coord> coords = new ArrayList<>();

    public Boolean getActive() {
        return active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Coord> getCoords() {
        return coords;
    }

    public void setCoords(List<Coord> coords) {
        this.coords = coords;
    }

    //    @Column(name = "home_number")
//    private String homeNumber;
}
