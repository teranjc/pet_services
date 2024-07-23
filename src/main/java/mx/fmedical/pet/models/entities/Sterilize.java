package mx.fmedical.pet.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "sterilize")
public class Sterilize implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sterilize")
    private String idSterilize;

    private String diffusion;

    private String size;

    @Column(name = "institution_assigment")
    private String institutionAssigment;

    @Column(name = "reason")
    private Integer reason;

    private String cause;

    private Integer type;

    @ManyToOne
    @JoinColumn(name = "id_vet_assigment", referencedColumnName = "id_vet_assigment")
    private VetAssigment vetAssigment;

    @ManyToOne
    @JoinColumn(name = "id_pet", referencedColumnName = "id_pet")
    private Pet pet;

    @Column(name = "registration_date")
    private Timestamp registrationDate;

}