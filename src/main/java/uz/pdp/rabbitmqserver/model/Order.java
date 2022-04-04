package uz.pdp.rabbitmqserver.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private int id;
    private String date;
    private double price;
}
