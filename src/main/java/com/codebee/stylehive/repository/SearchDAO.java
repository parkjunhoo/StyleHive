package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.UserInfoEntity;
import com.codebee.stylehive.jpa.entity.*;
import com.codebee.stylehive.jpa.entity.community.CommunityEntity;
import com.codebee.stylehive.jpa.entity.product.ProductBrandEntity;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface SearchDAO {
    // 검색 통계 수집 로직
    void logSearch(String keyword);

    // 상품 검색 기능
    List<ProductEntity> searchProducts(String keyword);

    // 유저 검색 기능
    List<UserInfoEntity> searchUsers(String keyword, HttpServletRequest request);

    // 커뮤니티 검색 기능
    List<CommunityEntity> searchCommunities(String keyword);

    // 추천 상품 상위 5개
    List<ProductEntity> getTop5ProductsByTenderCount();

    // 인기 검색어 상위 20개
    List<SearchStatsEntity> getTop20PopularSearches();

    // 인기 브랜드 상위 6개
    List<ProductBrandEntity> getTop6BrandsByTenderCount();

    // 연관 검색어 상위 5개
    List<ProductEntity> getRelatedProducts(String keywords);

    // 브랜드 자동 완성 검색어
    List<ProductBrandEntity> getBrandNamesAutoComplete(String keyword);

    // 상품 이름 자동 완성 검색어
    List<ProductEntity> getProductNamesAutoComplete(String keyword);
}