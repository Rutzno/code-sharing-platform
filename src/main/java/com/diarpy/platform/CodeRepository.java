package com.diarpy.platform;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Mack_TB
 * @version 1.0.7
 * @since 12/20/2020
 */

public interface CodeRepository extends CrudRepository<Code, String> {

    /*@Query("select c from Code c limit 10 order by c.date desc")
    List<Code> latestCode();*/

    List<Code> findTop10ByTimeLessThanEqualAndViewsLessThanEqualOrderByDateDesc(long time, int views);
}
