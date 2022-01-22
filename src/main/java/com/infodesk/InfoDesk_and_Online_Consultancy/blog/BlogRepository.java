package com.infodesk.InfoDesk_and_Online_Consultancy.blog;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface BlogRepository extends JpaRepository<Blog, Long>{



}

