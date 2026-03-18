package pl.javastart.todoapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Tytul nie moze byc pusty")
    @Size(min = 1, max = 100, message = "Tytul musi miec minimum 1 do 100 znakow")
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;

    public enum Status{
        NEW,
        IN_PROGRESS,
        DONE
    }

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
        if(this.status == null){
            this.status = Status.NEW;
        }
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Status getStatus() {return status;}
    public void setStatus(Status status) {this.status = status;}

    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
}
