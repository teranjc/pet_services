package mx.fmedical.pet.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Formula;

import java.io.Serializable;

@Data
@Entity
@Table(name = "vet_assigment")
public class VetAssigment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vet_assigment")
    private String idVetAssigment;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "professional_license")
    private String professionalLicense;

    @Formula("LTRIM(RTRIM(CONCAT(LTRIM(RTRIM(name)), ' ', LTRIM(RTRIM(last_name)), ' - ', LTRIM(RTRIM(professional_license)))))")
    private String fullName;
}