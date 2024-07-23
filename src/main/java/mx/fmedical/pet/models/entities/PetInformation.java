package mx.fmedical.pet.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "pet_information")
public class PetInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pet_information")
    private String idPetInformation;

    @Column(name = "reason_consultation")
    private String reasonConsultation;

    @Column(name = "direct_interrogation")
    private String directInterrogation;

    @Column(name = "level_attention")
    private String levelAttention;

    private String behavior;

    private String march;

    @Column(name = "nutritional_condition")
    private String nutritionalCondition;

    private String fr;

    private String fc;

    private String temp;

    private String trc;

    private String diagnostic;

    private String treatment;

    private String hydration;

    private String observation;

    private Integer type;

    @Column(name = "registration_date")
    private Timestamp registrationDate;

    @ManyToOne
    @JoinColumn(name = "id_vet_assigment", referencedColumnName = "id_vet_assigment")
    private VetAssigment vetAssigment;

    @ManyToOne
    @JoinColumn(name = "id_pet", referencedColumnName = "id_pet")
    private Pet pet;

}