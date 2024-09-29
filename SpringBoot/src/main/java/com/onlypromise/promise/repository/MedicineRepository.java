package com.onlypromise.promise.repository;

import com.onlypromise.promise.domain.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    // 약품 코드로 Medicine 엔티티를 찾는 메서드
    Optional<Medicine> findByProductCode(String productCode);

    // 약품의 ID로 Medicine 엔티티를 찾는 메서드
    Optional<Medicine> findById(Long id);
}