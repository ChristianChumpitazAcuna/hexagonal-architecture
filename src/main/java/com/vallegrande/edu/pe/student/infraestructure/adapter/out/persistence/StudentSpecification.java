package com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence;

import com.vallegrande.edu.pe.student.infraestructure.adapter.out.persistence.entity.StudentEntity;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {

    public static Specification<StudentEntity> containsText(String text) {
        return (root, query, criteriaBuilder) -> {
            String likeText = "%" + text.toLowerCase() + "%";

            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), likeText),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), likeText),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), likeText),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("phone").as(String.class)), likeText),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("address")), likeText),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("dni").as(String.class)), likeText)
            );
        };
    }

    public static Specification<StudentEntity> hasStatus(boolean status) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }
}
