package com.codebee.stylehive.repository;

import com.codebee.stylehive.dto.ProductDTO;
import com.codebee.stylehive.dto.ProductDealDTO;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;
import com.codebee.stylehive.jpa.repository.ProductRepo;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@NoArgsConstructor
public class ProductDAOImpl implements ProductDAO {
    ProductRepo repo;
    SqlSession ss;

    @Autowired
    public ProductDAOImpl(ProductRepo repo, SqlSession ss) {
        this.repo = repo;
        this.ss = ss;
    }


    @Override
    public ProductEntity findById(int id) {
        ProductEntity result = this.repo.findById(id).get();
        result.setWishCount(ss.selectOne("com.codebee.stylehive.product.selectProductWishCount", id));
        return result;
    }

    @Override
    public List<ProductDealDTO> findAllProductDealByProductId(int productId) {

        return ss.selectList("com.codebee.stylehive.product.selectProductDealDone", productId);
    }

    @Override
    public List<ProductDTO> findProductByBrandOrderByDealCount(int brandId, int limit, int currentProductId) {
        Map<String, Object> map = new HashMap<>();
        map.put("brandId", brandId);
        map.put("limit", limit);
        map.put("currentProductId", currentProductId);
        return ss.selectList("com.codebee.stylehive.product.selectProductByBrandId", map);
    }
}
