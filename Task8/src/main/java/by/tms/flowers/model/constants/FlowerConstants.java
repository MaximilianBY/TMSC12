package by.tms.flowers.model.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter

public class FlowerConstants {
    String ROSE = "Роза";
    String TULIP = "Тюльпан";
    String ASTER = "Астра";
    String HERBERA = "Гербера";
    double PRICEROSE = 4.5;
    double PRICETULIP = 2.7;
    double PRICEASTER = 3.1;
    double PRICEHERBERA = 1.9;
}
