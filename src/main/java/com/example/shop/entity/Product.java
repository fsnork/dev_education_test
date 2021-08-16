package com.example.shop.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private double price;

    @Column(name = "amount")
    private int amount;

    @Column(name = "height")
    private double height;

    @Column(name = "power")
    private int power;

    @Column(name = "number_of_chambers")
    private int numberOfChambers;

    @Column(name = "volume")
    private double volume;

    @Column(name = "freshzone")
    private int freshzone;

    @Column(name = "max_power")
    private double maxPower;

    @Column(name = "auto_programs")
    private int autoPrograms;

    @Column(name = "grill")
    private int grill;

    @Column(name = "diagonal")
    private double diagonal;

    @Column(name = "matrix_type")
    private String matrixType;

    @Column(name = "operation_system")
    private String operationSystem;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Id: %d, Type: %s, Model: %s, Price: %f, Amount: %d, Height: %f, Power: %d, ",
                this.getId(), this.getType(), this.getModel(), this.getPrice(), this.getAmount(), this.getHeight(),
                this.getPower()));
        switch (type) {
            case ("Fridge"):
                String frz;
                if (this.freshzone == 1) {
                    frz = "true";
                } else {
                    frz = "false";
                }
                builder.append(String.format("Number of chambers: %d, Volume: %f, Freshzone: %s",
                        this.numberOfChambers, this.volume, frz));
                break;
            case ("Microwave"):
                String gr;
                if (this.grill == 1) {
                    gr = "true";
                } else {
                    gr = "false";
                }
                builder.append(String.format("Volume: %f, Max power: %f, Number of auto programs: %d, Grill: %s",
                        this.volume, this.maxPower, this.autoPrograms, gr));
                break;
            case ("TV"):
                builder.append(String.format("Diagonal: %f, Matrix type: %s, Operation system: %s",
                        this.diagonal, this.matrixType, this.operationSystem));
                break;
            default:
                return "";
        }
        return builder.toString();
    }

}
