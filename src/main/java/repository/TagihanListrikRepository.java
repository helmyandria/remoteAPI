package repository;

import model.Akun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagihanListrikRepository extends JpaRepository<Akun, String> {
}
