package id.pelindo.remote.repository;

import id.pelindo.remote.model.Akun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AkunRepository extends JpaRepository<Akun, String> {

    @Query(value = "select * from mobile_akun where username = :username and password = :password", nativeQuery = true)
    Akun findLoginByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
