package com.cinemille.core;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieDateSpecification implements Specification<Movie> {

    private final LocalDate releaseDate;
    private final LocalDate endDate;

    public MovieDateSpecification(LocalDate releaseDate, LocalDate endDate) {
        this.releaseDate = releaseDate;
        this.endDate = endDate;
    }

    @Override
    public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (releaseDate != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startDate"), releaseDate));
        }

        if (endDate != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("endDate"), endDate));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}