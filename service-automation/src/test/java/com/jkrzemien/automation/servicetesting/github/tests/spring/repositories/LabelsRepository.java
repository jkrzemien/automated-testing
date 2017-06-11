package com.jkrzemien.automation.servicetesting.github.tests.spring.repositories;

import com.jkrzemien.automation.servicetesting.github.models.Label;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Interface definition for Spring's JPA "automagic" repositories
 *
 * @author Juan Krzemien
 */
public interface LabelsRepository extends PagingAndSortingRepository<Label, Long> {
}
