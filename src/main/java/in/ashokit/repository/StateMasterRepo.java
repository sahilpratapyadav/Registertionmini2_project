package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.StateMasterEntity;

public interface StateMasterRepo extends JpaRepository<StateMasterEntity,Long> {

}
