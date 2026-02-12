package vn.edu.hcmut.cse.adsoftweng.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
  @Query(
    value = "SELECT * FROM students WHERE UNACCENT(LOWER(name)) LIKE UNACCENT(LOWER(CONCAT('%', :name, '%')))", 
    nativeQuery = true
  )
  List<Student> findByNameContaining(@Param("name") String name);
}
