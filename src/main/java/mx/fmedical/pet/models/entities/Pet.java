package mx.fmedical.pet.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Data
@Entity
@Table(name = "pet")
public class Pet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pet")
    private String idPet;

    private String name;

    private String species;

    private String breed;

    private String age;

    private String weight;

    private String sex;

    private String color;

    @Column(name = "current_vaccination")
    private String currentVaccination;

    @ManyToOne
    @JoinColumn(name = "id_owner_information", referencedColumnName = "id_owner_information")
    private OwnerInformation ownerInformation;

}