package id.pelindo.remote.repository;

import id.pelindo.remote.model.Akun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AkunRepository extends JpaRepository<Akun, String> {

    @Query(value = "SELECT ma.USERNAME, ma.PASSWORD, ma.ROLE, psi.ID, psi.CUSTOMER_NAME, psi.INSTALLATION_CODE, psi.INSTALLATION_ADDRESS, psi.INSTALLATION_TYPE, psi.POWER_CAPACITY, psi.BRANCH_ID, psi.PROFIT_CENTER, psi.INSTALLATION_NUMBER, psi.MULTIPLY_FACT FROM PROP_SERVICES_INSTALLATION psi JOIN MOBILE_AKUN ma ON psi.CUSTOMER_ID = ma.CUSTOMER_ID WHERE ma.USERNAME=:username AND ma.PASSWORD=:password", nativeQuery = true)
    List<Akun> findLoginByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
