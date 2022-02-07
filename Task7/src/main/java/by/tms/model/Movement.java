package by.tms.model;
/*
решил что какие-то базовые функции вроде запуска, движения стоит отнести к интерфейсам, потом проще будет эти же методы
применить к другим ТС, которые не относятся к классу Car
 */

interface Movement {
    public void startEngine();

    public void stopEngine();

    public void travel();

    public void refillBank();
}
