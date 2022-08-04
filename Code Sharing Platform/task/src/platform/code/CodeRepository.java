package platform.code;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeRepository extends JpaRepository<Code, Long> {

    List<Code> findAllByOrderByDateDesc();
    List<Code> findTop10ByOrderByDateDesc();
}
