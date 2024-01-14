package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.CommunityEntity;
import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.jpa.entity.UserInfoEntity;

import java.util.List;

public interface SearchDAO {
    // 상품 검색 기능
    List<ProductEntity> searchProducts(String keyword);

    // 유저 검색 기능
    List<UserInfoEntity> searchUsers(String keyword);

    // 커뮤니티 검색 기능
    List<CommunityEntity> searchCommunities(String keyword);
}