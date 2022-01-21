package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import org.springframework.samples.petclinic.model.BaseEntity;

@Entity
@Getter
@Setter
public class RecoveryRoom extends BaseEntity {

    @Size(min = 3, max = 50)
    @NotNull
    String name;

    @Min(0)
    @NotNull
    double size;
    @NotNull
    boolean secure;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    RecoveryRoomType roomType;
}
