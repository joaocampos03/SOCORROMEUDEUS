package br.com.joaocampos.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * 
 * ID
 * Usuário (ID_USUARIO)
 * Descrição
 * Título
 * Data de início
 * Data de término
 * Prioridade
 * 
 */

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50)
    private String tittle;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;

    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public void setTittle(String tittle) throws Exception{
        if (tittle.length() > 50) {
            throw new Exception("O campo tittle deve conter no máximo 50 caracteres!");
        }
        this.tittle = tittle;
    }

}
