package by.tms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@SuperBuilder
public class Category extends BaseEntity {

  private String name;
  private String imageName;

  @Override
  public BaseEntity clone() {
    return null;
  }
}
