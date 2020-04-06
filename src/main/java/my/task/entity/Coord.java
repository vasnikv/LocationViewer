package my.task.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "coords")
public class Coord {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Column
    private Double x;

    @Column
    private Double y;

    @Column
    private Timestamp datetime;

    @Column
    private Long previous;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public Long getPrevious() {
        return previous;
    }

    public void setPrevious(Long previous) {
        this.previous = previous;
    }
}
