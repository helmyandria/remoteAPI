package id.pelindo.remote.repository;

import id.pelindo.remote.model.ServicesTransaction;
import jdk.nashorn.internal.objects.annotations.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Repository
public interface ServicesTransactionRepository extends JpaRepository<ServicesTransaction, String> {

//    @Function(name = "GENERATE_NOMOR_TRANS(1,TRANS_LISTRIK,43,6")

    @Query(nativeQuery = true, value = "CALL REMOTE.GENERATE_NOMOR_TRANS(:param1,:param2,:param3,:param4) ")
    String generateNomor(@Param("param1") String param1, @Param("param2") String param2, @Param("param3") String param3, @Param("param4") String param4 );

//    @Procedure(procedureName="GENERATE_NOMOR_TRANS")
//    String generateNomor(@Param("P_BE_ID") String P_BE_ID, @Param("P_MODULE_TYPE") String P_MODULE_TYPE, @Param("P_PARAM1") String P_PARAM1, @Param("p_padding") String p_padding );

    @Query(value = "INSERT INTO PROP_SERVICES_TRANSACTION (INSTALLATION_TYPE, PROFIT_CENTER, CUSTOMER, PERIOD, AMOUNT, INSTALLATION_NUMBER, BILLING_TYPE, ID_INSTALASI, GL_ACCOUNT, BRANCH_ID, INSTALLATION_CODE, CUSTOMER_NAME, STATUS_DINAS) VALUES ('L-Sambungan Tes', '10201', '30006' , '12.2020', '34745288', '52000015', 'ZM02', '15', '4080200000', '2', 'L/30006/03', 'BANK MANDIRI (PERSERO) TBK, PT', 'non kedinasan') ", nativeQuery = true)
    void insertData();

}
