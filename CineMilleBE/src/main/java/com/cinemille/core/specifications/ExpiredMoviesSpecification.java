package com.cinemille.core.specifications;

import com.cinemille.core.Movie;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class ExpiredMoviesSpecification implements Specification<Movie> {

    @Override
    public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
           return criteriaBuilder.lessThan(root.get("endDate"), LocalDate.now());
    }
}
