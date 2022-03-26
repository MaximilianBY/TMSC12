package by.tms.task11_3;

public class Studio {

  public void dressMan(Clothes[] clothes) {
    for (Clothes clothing : clothes) {
      if (ClothingMens.class.isAssignableFrom(clothing.getClass())) {
        ((ClothingMens) clothing).dressMan();
      }
    }
  }

  public void dressWoman(Clothes[] clothes) {
    for (Clothes clothing : clothes) {
      if (ClothingWomens.class.isAssignableFrom(clothing.getClass())) {
        ((ClothingWomens) clothing).dressWoman();
      }
    }
  }
}
