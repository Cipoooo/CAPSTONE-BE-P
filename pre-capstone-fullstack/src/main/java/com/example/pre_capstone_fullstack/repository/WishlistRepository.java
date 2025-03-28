package com.example.pre_capstone_fullstack.repository;

import com.example.pre_capstone_fullstack.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
}
