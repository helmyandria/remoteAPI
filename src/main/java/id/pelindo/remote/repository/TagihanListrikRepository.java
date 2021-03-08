package id.pelindo.remote.repository;

import id.pelindo.remote.model.Akun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagihanListrikRepository extends JpaRepository<Akun, String> {
}
