package com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence;

import com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.entity.StudentEntity;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {

    public static Specification<StudentEntity> containsText(String text) {
        return (root, query, criteriaBuilder) -> {
            try {
                Long numericValue = Long.parseLong(text);
                return criteriaBuilder.or(
                        criteriaBuilder.equal(root.get("dni"), numericValue),
                        criteriaBuilder.equal(root.get("phone"), numericValue)
                );
            } catch (NumberFormatException e) {
                String likeText = "%" + text.toLowerCase() + "%";
                return criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), likeText),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), likeText),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), likeText),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("address")), likeText)
                );
            }
        };
    }

    public static Specification<StudentEntity> hasStatus(boolean status) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("status"), status);
    }
}
