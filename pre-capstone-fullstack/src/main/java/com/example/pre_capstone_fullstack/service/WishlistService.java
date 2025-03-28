package com.example.pre_capstone_fullstack.service;


import com.example.pre_capstone_fullstack.entity.Wishlist;
import com.example.pre_capstone_fullstack.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;

    public Wishlist addToWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public void removeFromWishlist(Long id) {
        wishlistRepository.deleteById(id);
    }

    public List<Wishlist> getUserWishlist(Long userId) {
        return wishlistRepository.findAll();
    }
}
