package org.springframework.samples.petclinic.recoveryroom;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {
    List<RecoveryRoom> findAll();

    @Query("SELECT recoveryRoomType FROM RecoveryRoom recoveryRoom")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();


    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);

    @Query("SELECT r.recoveryRoomType FROM RecoveryRoom r where r.recoveryRoomType like ?1")
    RecoveryRoomType getRecoveryRoomType(String name);

    @Query("SELECT r FROM RecoveryRoom r where size > ?1")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
