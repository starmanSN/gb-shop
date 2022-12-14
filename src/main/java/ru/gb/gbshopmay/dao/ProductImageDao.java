package ru.gb.gbshopmay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.gb.gbshopmay.entity.ProductImage;

import java.util.List;

public interface ProductImageDao extends JpaRepository<ProductImage, Long> {

    @Query(value = "SELECT product_image.path FROM product_image WHERE product_image.product_id = :id LIMIT 1", nativeQuery = true)
    String findImageNameByProductId(@Param("id") Long id);

//    todo дз 11 добавить метод чтобы доставать все изображения

    @Query(value = "SELECT * from product_image", nativeQuery = true)
    List<String> findAllImages();

    @Query(value = "SELECT product_image.path FROM product_image WHERE product_image.product_id = :id", nativeQuery = true)
    List<String> findAllImagesByProductId(@Param("id") Long id);

}
