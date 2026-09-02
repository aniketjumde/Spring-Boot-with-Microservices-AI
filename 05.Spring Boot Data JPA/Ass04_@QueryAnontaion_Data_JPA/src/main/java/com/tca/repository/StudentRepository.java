package com.tca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tca.entity.Student;
import com.tca.enums.Gender;

import jakarta.transaction.Transactional;

public interface StudentRepository extends CrudRepository<Student,Integer> {
	
	//JPQL (DataBase Independent Query)
	@Query("SELECT s FROM Student s")
	public List<Student> fetchByAllUsingJPQL();
	
	
	//SQL (DataBase Dependent Query)
	@Query(value="SELECT * FROM student",nativeQuery=true)
	public List<Student> fetchByAllUsingSQL();
	
	
	//@Query("SELECT s FROM Student s WHERE s.per>=?1 AND s.per<=?2")        // JPQL with Postitional Parameters
	@Query("SELECT s FROM Student s WHERE s.per>=:low AND s.per<=:high")   // JPQL with Name Parameters
	public List<Student> findPercentageRangeUsingJPQL(@Param("low") Double start,@Param("high") Double end);

	
	//@Query(value="SELECT * FROM Student WHERE PER>=?1 AND PER<=?2", nativeQuery = true)   // SQL with Postitional Parameters
	@Query(value="SELECT * FROM Student WHERE PER>=:low AND PER<=:high", nativeQuery = true)   // SQL with Named Parameters
	public List<Student> findPercentageRangeUsingSQL(@Param("low") Double start,  @Param("high") Double end);
	
		
	//==========================================      Scalar Projection Using JPQL   ==============================================
	
	//@Query("SELECT s.gender,s.name,s.per FROM Student s WHERE s.gender=?1 AND s.per>?2")
	@Query("SELECT s.gender,s.name,s.per FROM Student s WHERE s.gender=:gender AND s.per>:per")
	public List<Object[]> findByGenderAndPerUsingJPQL(@Param("gender") Gender gender,@Param("per") Double per);
	
	//@Query(value="SELECT gender,name,per FROM Student WHERE gender=?1 AND per>?2",nativeQuery=true)
	@Query(value="SELECT gender,name,per FROM student WHERE gender=:studentGender AND per>:studentPer",nativeQuery=true)
	public List<Object[]> findByGenderAndPerUsingSQL(@Param("studentGender") Gender gender,@Param("studentPer") Double per);

	
	
	//Update Record 
	@Modifying
	@Transactional
	@Query("Update Student s Set s.name= :name Where s.rno=:rno")
	public void updateByName(@Param("name") String name,@Param("rno") Integer rno);
	
	
	//Delete Student Records
	@Modifying
	@Transactional
	@Query("Delete FROM Student s Where s.rno=:rno")
	public void deleteByrno(@Param("rno") Integer rno);
	
}
