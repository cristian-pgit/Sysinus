package cl.naitsirc.sysinus.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "telephones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int telephoneID;


    private int number;


    private int cityCode;

    private int countryCode;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Telephone: {");
        sb.append("number=").append(number);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", countryCode=").append(countryCode);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telephone telephone = (Telephone) o;
        return telephoneID == telephone.telephoneID && number == telephone.number && cityCode == telephone.cityCode && countryCode == telephone.countryCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(telephoneID, number, cityCode, countryCode);
    }
}
