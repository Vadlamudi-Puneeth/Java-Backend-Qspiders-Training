package com.practise.cachepractise.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.cachepractise.entity.FileData;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long>{

}
