package id.pelindo.remote.repository;

import id.pelindo.remote.model.PPJU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PPJURepository extends JpaRepository<PPJU, String> {

    @Query(value = "SELECT * FROM PROP_SERVICES_INSTALLATION_C WHERE INSTALLATION_CODE = :installation_code", nativeQuery = true)
    List<PPJU> findPPJU(@Param("installation_code") String installation_code);

}
