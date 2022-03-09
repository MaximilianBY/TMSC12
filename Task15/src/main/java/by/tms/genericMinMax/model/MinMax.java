package by.tms.genericMinMax.model;

public class MinMax<T> {

  private T[] nums;

  public MinMax() {
  }

  public MinMax(T[] nums) {
    this.nums = nums;
  }

  public void printMinMaxValue() {
    int maxValue = 0, minValue = (int) nums[nums.length - 1];
    for (T value : nums) {
      maxValue = Math.max(maxValue, (int) value);
      minValue = Math.min(minValue, (int) value);
    }
    System.out.println(maxValue);
    System.out.println(minValue);
  }
}
