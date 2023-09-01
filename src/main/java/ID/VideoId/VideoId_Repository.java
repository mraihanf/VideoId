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

    @Query(value = "SELECT * FROM videoid where (hasil ILIKE 'BA%') AND (hasil ILIKE '%?1%')",
            countQuery = "SELECT count(*) FROM videoid where (hasil ILIKE 'BA%') AND (hasil ILIKE '%?1%')",
            nativeQuery = true)
    Page<VideoId> search1(String search, Pageable pageable);

    @Query(value = "SELECT * FROM videoid where (hasil ILIKE 'TV%') AND (hasil ILIKE '%?1%')",
            countQuery = "SELECT count(*) FROM videoid where (hasil ILIKE 'TV%') AND (hasil ILIKE '%?1%')",
            nativeQuery = true)
    Page<VideoId> search2(String search, Pageable pageable);

    @Query(value = "SELECT * FROM videoid where (hasil ILIKE 'TR%') AND (hasil ILIKE '%?1%')",
            countQuery = "SELECT count(*) FROM videoid where (hasil ILIKE 'TR%') AND (hasil ILIKE '%?1%')",
            nativeQuery = true)
    Page<VideoId> search3(String search, Pageable pageable);

    @Query(value = "SELECT * FROM videoid where (hasil ILIKE 'PB%') AND (hasil ILIKE '%?1%')",
            countQuery = "SELECT count(*) FROM videoid where (hasil ILIKE 'PB%') AND (hasil ILIKE '%?1%')",
            nativeQuery = true)
    Page<VideoId> search4(String search, Pageable pageable);

    @Query(value = "SELECT * FROM videoid where (hasil ILIKE 'BU%') AND (hasil ILIKE '%?1%')",
            countQuery = "SELECT count(*) FROM videoid where (hasil ILIKE 'BU%') AND (hasil ILIKE '%?1%')",
            nativeQuery = true)
    Page<VideoId> search5(String search, Pageable pageable);

    @Query(value = "SELECT * FROM videoid where (hasil ILIKE 'SI%') AND (hasil ILIKE '%?1%')",
            countQuery = "SELECT count(*) FROM videoid where (hasil ILIKE 'SI%') AND (hasil ILIKE '%?1%')",
            nativeQuery = true)
    Page<VideoId> search6(String search, Pageable pageable);

    @Query(value = "SELECT * FROM videoid where (hasil ILIKE 'AI%') AND (hasil ILIKE '%?1%')",
            countQuery = "SELECT count(*) FROM videoid where (hasil ILIKE 'AI%') AND (hasil ILIKE '%?1%')",
            nativeQuery = true)
    Page<VideoId> search7(String search, Pageable pageable);

    @Query(value = "SELECT * FROM videoid where (hasil ILIKE 'RT%') AND (hasil ILIKE '%?1%')",
            countQuery = "SELECT count(*) FROM videoid where (hasil ILIKE 'RT%') AND (hasil ILIKE '%?1%')",
            nativeQuery = true)
    Page<VideoId> search8(String search, Pageable pageable);

    @Query(value = "SELECT * FROM videoid where (hasil ILIKE 'SF%') AND (hasil ILIKE '%?1%')",
            countQuery = "SELECT count(*) FROM videoid where (hasil ILIKE 'SF%') AND (hasil ILIKE '%?1%')",
            nativeQuery = true)
    Page<VideoId> search9(String search, Pageable pageable);

    @Query(value = "SELECT * FROM videoid where (hasil ILIKE 'LT%') AND (hasil ILIKE '%?1%')",
            countQuery = "SELECT count(*) FROM videoid where (hasil ILIKE 'LT%') AND (hasil ILIKE '%?1%')",
            nativeQuery = true)
    Page<VideoId> search10(String search, Pageable pageable);

    @Query(value = "SELECT * FROM videoid where (hasil ILIKE 'VP%') AND (hasil ILIKE '%?1%')",
            countQuery = "SELECT count(*) FROM videoid where (hasil ILIKE 'VP%') AND (hasil ILIKE '%?1%')",
            nativeQuery = true)
    Page<VideoId> search11(String search, Pageable pageable);

    @Query(value = "SELECT * FROM videoid where (hasil ILIKE 'ST%') AND (hasil ILIKE '%?1%')",
            countQuery = "SELECT count(*) FROM videoid where (hasil ILIKE 'ST%') AND (hasil ILIKE '%?1%')",
            nativeQuery = true)
    Page<VideoId> search12(String search, Pageable pageable);



}
