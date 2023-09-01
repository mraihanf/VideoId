package ID.VideoId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoId_Repository extends JpaRepository<VideoId, Integer>{
    
    @Query(value = "SELECT max(norut) FROM videoid where tahun = ?1",
        countQuery = "SELECT max(norut) FROM videoid where tahun = ?1",
        nativeQuery = true)
    Integer findByMaxnourut(String tahun);

    @Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM videoid c WHERE (c.tahun = ?1) AND (norut = ?2)",
        countQuery = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM videoid c WHERE (c.tahun = ?1) AND (no_urut = ?2)",
        nativeQuery = true)
    boolean findBynourut(String tahun, Integer norut);

    @Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM videoid c WHERE c.tahun = ?1",
        countQuery = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM videoid c WHERE c.tahun = ?1",
        nativeQuery = true)
    boolean findbytahun(String tahun);

    @Query(value = "SELECT * FROM videoid where hasil ILIKE %?1%",
            countQuery = "SELECT count(*) FROM videoid where hasil ILIKE %?1%",
            nativeQuery = true)
    Page<VideoId> search(String search, Pageable pageable);

}
