package espe.edu.ec.IAGenerative.repository;

import espe.edu.ec.IAGenerative.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
