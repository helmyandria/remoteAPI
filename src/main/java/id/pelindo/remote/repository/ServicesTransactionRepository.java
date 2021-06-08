package id.pelindo.remote.repository;

import id.pelindo.remote.model.ServicesTransaction;
import jdk.nashorn.internal.objects.annotations.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import java.util.List;

@Repository
public interface ServicesTransactionRepository extends JpaRepository<ServicesTransaction, String> {

    @Modifying
    @Query(value = "INSERT INTO PROP_SERVICES_TRANSACTION (ID, INSTALLATION_TYPE, PROFIT_CENTER, CUSTOMER, " +
            "PERIOD, AMOUNT, INSTALLATION_NUMBER, BILLING_TYPE, ID_INSTALASI, GL_ACCOUNT, BRANCH_ID, INSTALLATION_CODE, CUSTOMER_NAME, " +
            "CREATED_DATE, CREATED_BY, STATUS_DINAS) " +
            "VALUES (:id, :installation_type, :profit_center, :customer," +
            " :period, :amount, :installation_number, :billing_type, :id_instalasi, :gl_account, :branch_id, :installation_code, :customer_name," +
            " :created_date, :created_by, :status_dinas) ", nativeQuery = true)
    @Transactional
    void insertData(@Param("id") String id,
                    @Param("installation_type") String installation_type,
                    @Param("profit_center") String profit_center,
                    @Param("customer") String customer,
                    @Param("period") String period,
                    @Param("amount") String amount,
                    @Param("installation_number") String installation_number,
                    @Param("billing_type") String billing_type,
                    @Param("id_instalasi") String id_instalasi,
                    @Param("gl_account") String gl_account,
                    @Param("branch_id") String branch_id,
                    @Param("installation_code") String installation_code,
                    @Param("customer_name") String customer_name,
                    @Param("created_date") String created_date,
                    @Param("created_by") String customer_by,
                    @Param("status_dinas") String status_dinas
                    );

}
