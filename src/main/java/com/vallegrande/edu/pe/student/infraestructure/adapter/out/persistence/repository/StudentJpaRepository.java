package com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.repository;

import com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long>,
        JpaSpecificationExecutor<StudentEntity> {

    List<StudentEntity> findByStatus(boolean status);

    @Modifying
    @Query("update StudentEntity s set s.status = ?2 where s.id = ?1")
    void changeStatus(Long id, boolean status);

    boolean existsByPhone(Long phone);

    boolean existsByDni(Long dni);

    boolean existsByEmail(String email);
}
