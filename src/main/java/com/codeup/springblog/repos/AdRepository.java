package com.codeup.springblog.repos;

import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long> {
//Query methods
    // select * from ads where title =  ?
    Ad findByTitle(String title);

    //you can use "@Query() to use the old query types for more complicated
    @Query("from Ad a where a.title like %:term%")
    List<Ad> searchByTitleLike(@Param("term") String term);
}
