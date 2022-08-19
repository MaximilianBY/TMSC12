package by.tms.eshop.dto;

import com.opencsv.bean.CsvBindByName;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

  private int id;
  @CsvBindByName
  private String name;
  @CsvBindByName
  private String imagePath;
  private Set<ProductDto> productDtoSet;
}
