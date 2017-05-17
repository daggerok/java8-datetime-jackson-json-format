package daggerok.test;

import daggerok.test.audit.AbstractAuditEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class TestEntity extends AbstractAuditEntity {

  private static final long serialVersionUID = 6905466020927386504L;

  private String content;
}
