package by.tms.task11_3;

public class Main {

  public static void main(String[] args) {
    Clothes[] clothes = {new Tie(ClothesSize.XXS, "Blue", 450),
        new Skirt(ClothesSize.S, "Red", 1000), new Pants(ClothesSize.XS, "Black", 410),
        new Tshirt(ClothesSize.M, "Rose", 500)};

    Studio studio = new Studio();
    studio.dressMan(clothes);
    studio.dressWoman(clothes);
  }
}
