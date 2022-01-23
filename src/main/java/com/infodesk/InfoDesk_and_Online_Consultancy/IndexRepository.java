package com.infodesk.InfoDesk_and_Online_Consultancy;


import com.infodesk.InfoDesk_and_Online_Consultancy.blog.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface IndexRepository extends  JpaRepository<Blog, Long>{
    
}

