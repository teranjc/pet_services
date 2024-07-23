package mx.fmedical.pet.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "treatment")
public class Treatment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_treatment")
    private String idTreatment;

    private Integer percent;

    @Column(name = "lot_number")
    private String lotNumber;

    @Column(name = "date_expiry")
    private String dateExpiry;

    @Column(name = "dosage")
    private Double dosage;

    @Column(name = "name_treatment")
    private String nameTreatment;

    private Boolean antibiotic;

    private Boolean other;
    @ManyToOne
    @JoinColumn(name = "fk_id_sterilize", referencedColumnName = "id_sterilize")
    private Sterilize sterilize;

}