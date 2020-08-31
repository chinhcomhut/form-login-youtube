package com.codegym.wbdlaptop.service;

import com.codegym.wbdlaptop.model.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISingerService {
    Boolean existsByNameSinger(String nameSinger);
    Page<Singer> findAllByUserId(Long userId, Pageable pageable);
    Singer save(Singer singer);
    Optional<Singer> findById(Long id);
    void delete(Long id);
    Page<Singer> findAll(Pageable pageable);
    List<Singer> findAllList();
}
