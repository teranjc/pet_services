package mx.fmedical.pet.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Data
@Entity
@Table(name = "owner_information", schema = "public" )
public class OwnerInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_owner_information")
    private String idOwnerInformation;

    @Column(name = "full_name")
    private String fullName;

    private String address;

    private String phone;

    private String age;

}