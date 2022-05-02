package me.dio.academia.digital.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matriculas")
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "aluno_id")
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Matricula matricula = (Matricula) o;
    return id != null && Objects.equals(id, matricula.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
