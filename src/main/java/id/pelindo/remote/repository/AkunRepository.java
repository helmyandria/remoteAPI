package id.pelindo.remote.repository;

import id.pelindo.remote.model.Akun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AkunRepository extends JpaRepository<Akun, String> {

    @Query(value = "SELECT ma.USERNAME, ma.PASSWORD, ma.ROLE, psi.ID, psi.CUSTOMER_ID, psi.CUSTOMER_NAME, psi.INSTALLATION_CODE, psi.INSTALLATION_ADDRESS, psi.INSTALLATION_TYPE, psi.POWER_CAPACITY, psi.BRANCH_ID, psi.PROFIT_CENTER, psi.INSTALLATION_NUMBER, psi.MULTIPLY_FACT, psi.MINIMUM_USED, NVL(psi.MINIMUM_PAYMENT, 0) AS MINIMUM_PAYMENT, NVL(psi.BIAYA_ADMIN, 0) AS BIAYA_ADMIN, s.AMOUNT AS BIAYA_BEBAN FROM PROP_SERVICES_INSTALLATION psi JOIN MOBILE_AKUN ma ON psi.CUSTOMER_ID = ma.CUSTOMER_ID JOIN SERVICES s ON s.TARIFF_CODE = psi.TARIFF_CODE WHERE  ma.USERNAME=:username AND ma.PASSWORD=:password", nativeQuery = true)
    List<Akun> findLoginByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
