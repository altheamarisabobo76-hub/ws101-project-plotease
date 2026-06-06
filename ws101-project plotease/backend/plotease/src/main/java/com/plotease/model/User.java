package com.plotease.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String fullName;
    private String studentId;
    private String email;

    public Object getPassword() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPassword(String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPassword'");
    }

    public void setUserId(String userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setFullName(String fullName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setStudentId(String studentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setUserId1(String userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}