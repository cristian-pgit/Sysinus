package cl.naitsirc.sysinus.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name= "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends RepresentationModel <User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "telephone_Id", nullable = false)
    private List<Telephone> telephone;

    @Column()
    private LocalDateTime created;

    @Column()
    private LocalDateTime modified;

    @PrePersist
    private void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        modified = LocalDateTime.now();
    }

    @Column(nullable = false)
    private boolean isActive = true;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId=").append(userId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", telephone=").append(telephone);
        sb.append(", created=").append(created);
        sb.append(", modified=").append(modified);
        sb.append(", isactive=").append(isActive);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && isActive == user.isActive && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(telephone, user.telephone) && Objects.equals(created, user.created) && Objects.equals(modified, user.modified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, password, telephone, created, modified, isActive);
    }
}
