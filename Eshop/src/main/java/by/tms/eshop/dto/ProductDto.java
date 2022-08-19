package by.tms.eshop.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

  private int id;
  @CsvBindByName
  private String brand;
  @CsvBindByName
  private String model;
  @CsvBindByName
  private String description;
  @CsvBindByName
  private int price;
  @CsvBindByName
  private int quantity;
  private int categoryId;
  @CsvBindByName
  private String categoryName;
  @CsvBindByName
  private String imagePath;
}
