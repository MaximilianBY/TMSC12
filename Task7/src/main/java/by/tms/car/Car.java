package by.tms.car;
/*
абстрактный класс любого автомобиля.
 */

abstract class Car implements Movement {
    private String brandCar;
    private String modelCar;
    private String typeCar;
    private String colorCar;

    public Car(String brandCar, String modelCar, String typeCar, String colorCar) {
        this.brandCar = brandCar;
        this.modelCar = modelCar;
        this.typeCar = typeCar;
        this.colorCar = colorCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }
}
