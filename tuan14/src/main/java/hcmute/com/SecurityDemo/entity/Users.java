package hcmute.com.SecurityDemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {

        @Id
        @Column(name = "user_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;

        @Email
        private String email;

        @Column(length = 60, columnDefinition = "nvarchar(50) not null")
        private String name;

        private String password;

        private boolean enabled;

        @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinTable(
                name = "users_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id")
        )
        private Set<Role> roles = new HashSet<>();
}

