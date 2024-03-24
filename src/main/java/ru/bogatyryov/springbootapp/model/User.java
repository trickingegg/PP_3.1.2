package ru.bogatyryov.springbootapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name shouldn't be blank!")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name should have only letters!")
    private String firstName;

    @NotBlank(message = "Surname shouldn't be blank!")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Surname should have only letters!")
    private String lastName;

    @NotBlank(message = "Email shouldn't be blank")
    @Email(message = "Email should be valid")
    @Pattern(regexp = "^[a-zA-Z\\d]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$", message = "Email shouldn't have symbols before the '@'")
    private String email;

    public User() {}

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        return Objects.equals(id, other.id)&&
                Objects.equals(firstName, other.firstName) &&
                Objects.equals(lastName, other.lastName) &&
                Objects.equals(email, other.email);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id = : ").append(id).append('\n');
        sb.append("FirstName : ").append(firstName).append('\n');
        sb.append("LastName : ").append(lastName).append('\n');
        sb.append("Email : ").append(email).append('\n');
        return sb.toString();
    }
}