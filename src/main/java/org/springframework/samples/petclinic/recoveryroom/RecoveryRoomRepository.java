package org.springframework.samples.petclinic.recoveryroom;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {
    List<RecoveryRoom> findAll();

    @Query("Select distinct r From RecoveryRoomType r ")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);

    @Query("Select r from RecoveryRoomType r where r.name = ?1")
    RecoveryRoomType getRecoveryRoomType(String name);

    @Query("Select r from RecoveryRoom r where r.size > ?1")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
