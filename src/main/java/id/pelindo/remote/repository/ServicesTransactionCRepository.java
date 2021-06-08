package id.pelindo.remote.repository;

import id.pelindo.remote.model.ServicesTransaction;
import id.pelindo.remote.model.ServicesTransactionC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ServicesTransactionCRepository  extends JpaRepository<ServicesTransactionC,String> {

    @Modifying
    @Query(value = "INSERT INTO PROP_SERVICES_TRANSACTION_C (DESCRIPTION, PERCENTAGE, SERVICES_TRANSACTION_ID, BRANCH_ID) " +
            "VALUES (:description, :percentage, :services_transaction_id, :branch_id) ", nativeQuery = true)
    @Transactional
    void insertData(
            @Param("description") String description,
            @Param("percentage") String percentage,
            @Param("services_transaction_id") String services_transaction_id,
            @Param("branch_id") String branch_id
            );

}
