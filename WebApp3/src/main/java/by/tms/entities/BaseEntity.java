package by.tms.entities;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class BaseEntity {

  @Getter
  private int id;

  public BaseEntity(BaseEntity baseEntity) {
    if (Optional.ofNullable(baseEntity).isPresent()) {
      this.id = baseEntity.getId();
    }
  }

  public abstract BaseEntity clone();
}
