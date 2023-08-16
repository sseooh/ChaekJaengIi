package chaekjaengi.chaekjaengispring.repository;

import chaekjaengi.chaekjaengispring.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    List<Board> findAll();

    Optional<Board> findBoardByTitle(String title);

    int findAllCnt();

    List<Board> findListPaging(int startIndex, int pageSize);
}
