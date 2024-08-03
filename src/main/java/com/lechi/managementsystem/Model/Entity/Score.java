package com.lechi.managementsystem.Model.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
public class Score {

    private Integer scoreId;

    @OneToOne
    private Subject subject;

    private int value;



}
