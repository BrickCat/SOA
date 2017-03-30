package com.brickcat.repository;

import com.brickcat.moudle.Deparment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Seven on 17/3/29.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Deparment,Long>{
}
