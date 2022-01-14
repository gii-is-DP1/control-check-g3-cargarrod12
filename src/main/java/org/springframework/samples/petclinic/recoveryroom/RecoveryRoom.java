package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import org.springframework.samples.petclinic.model.BaseEntity;

@Entity
@Getter
@Setter
@Table(name = "recovery_room")
public class RecoveryRoom  extends BaseEntity {

    @NotNull
    @Size(max = 50, min = 3)
    String name;

    @NotNull
    @Min(0)
    double size;
    @NotNull
    boolean secure;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "roomTypeId",referencedColumnName = "id")
    RecoveryRoomType roomType;
}
