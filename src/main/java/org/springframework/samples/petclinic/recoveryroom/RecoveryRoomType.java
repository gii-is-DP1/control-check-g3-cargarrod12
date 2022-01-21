package org.springframework.samples.petclinic.recoveryroom;

import lombok.Getter;
import lombok.Setter;
import org.springframework.samples.petclinic.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class RecoveryRoomType extends BaseEntity {
    @Column(unique = true)
    @Size(min = 5, max = 50)
    @NotNull
    String name;
}
