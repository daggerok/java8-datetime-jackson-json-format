package daggerok.test;

import daggerok.test.audit.AbstractAuditEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(staticName = "of")
public class TestEntity extends AbstractAuditEntity {

  private static final long serialVersionUID = 6905466020927386504L;

  private String value;
}
