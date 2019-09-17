package com.codeup.springblog.repos;
import com.codeup.springblog.models.Image;
import org.springframework.data.repository.CrudRepository;


public interface ImageRepository extends CrudRepository<Image, Long> {
}
