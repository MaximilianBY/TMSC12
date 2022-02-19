package by.tms.task11_3;

public class Studio {

  public void dressMan(Clothes[] clothes) {
    for (Clothes clothing : clothes) {
      if (clothing instanceof ClothingMens) {
        ((ClothingMens) clothing).dressMan();
      }
    }
  }

  public void dressWoman(Clothes[] clothes) {
    for (Clothes clothing : clothes) {
      if (clothing instanceof ClothingWomens) {
        ((ClothingWomens) clothing).dressWoman();
      }
    }
  }
}
