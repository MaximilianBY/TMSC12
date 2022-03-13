package by.tms.genericMinMax.model;

public class MinMax<T> {

  private T[] nums;
  private T maxValue, minValue;

  public MinMax() {
  }

  public MinMax(T[] nums) {
    this.nums = nums;
  }
  /*
  Да знаю, метод сравнения ужасный, но сделал как понял, так и не пришла мысль как через compareTo вы предлагали сделать.
  Еще есть вопросы по классу Number, можно ли число привести к типу Number для дальнейшего сравнения, потому что в массив могут поступить разные типы чисел.
  к примеру {2, 9.5, 12, 46555.1}.
   */

  public void checkMinMaxValue() {
    T maxVal = nums[0], minVal = nums[nums.length - 1];
    for (T value : nums) {
      if (isInteger(value) && (Integer) maxVal < (Integer) value
          || isDouble(value) && (Double) maxVal < (Double) value) {
        maxVal = value;
      } else if (isInteger(value) && ((Integer) minVal > (Integer) value)
          || isDouble(value) && ((Double) minVal > (Double) value)) {
        minVal = value;
      }
      if (isString(value) && (maxVal.toString().length() < ((String) value).length())) {
        maxVal = value;
      } else if (isString(value) && (minVal.toString().length()
          > ((String) value).length())) {
        minVal = value;
      }
    }
    maxValue = maxVal;
    minValue = minVal;
  }

  private boolean isInteger(T value) {
    return value instanceof Integer;
  }

  private boolean isDouble(T value) {
    return value instanceof Double;
  }

  private boolean isString(T value) {
    return value instanceof String;
  }

  public T getMaxValue() {
    return maxValue;
  }

  public T getMinValue() {
    return minValue;
  }
}
