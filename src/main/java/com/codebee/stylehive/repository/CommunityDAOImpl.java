package com.codebee.stylehive.repository;

import com.codebee.stylehive.dto.CommunityDTO;
import com.codebee.stylehive.dto.ProductDTO;
import com.codebee.stylehive.jpa.entity.ImgThumbEntity;
import com.codebee.stylehive.jpa.entity.community.CommunityEntity;
import com.codebee.stylehive.jpa.repository.CommunityRepo;
import com.codebee.stylehive.util.Util;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Repository
public class CommunityDAOImpl implements CommunityDAO {

    CommunityRepo repo;
    SqlSession ss;

    @Autowired
    public CommunityDAOImpl(CommunityRepo repo, SqlSession ss) {
        this.repo = repo;
        this.ss = ss;
    }

    @Override
    public CommunityDTO findById(int id) {
        return this.ss.selectOne("com.codebee.stylehive.community.selectById", id);
    }

    @Override
    public List<CommunityDTO> findByProductId(int productId, int limit) {
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("productId", productId);
        paramMap.put("limit", limit);
        return ss.selectList("com.codebee.stylehive.community.selectByProductId", paramMap);
    }

    @Override
    public List<ImgThumbEntity> findImgByCommId(int commId) {
        return ss.selectList("com.codebee.stylehive.community.selectImgById", commId);
    }

    @Override
    public int countByProductId(int productId) {
        return ss.selectOne("com.codebee.stylehive.community.countByProductId", productId);
    }

    @Override
    public List<ProductDTO> findTagProductByCommId(int commId) {
        return ss.selectList("com.codebee.stylehive.community.selectTagProductById", commId);
    }

    @Override
    public int findByProductCateCount(int cateId) {
        return ss.selectOne("com.codebee.stylehive.community.selectProductCateCount", cateId);
    }

    @Override
    public List<CommunityDTO> findByProductCate(int cateId, int size, int page) {
        int count = findByProductCateCount(cateId);
        boolean hasNextPage = count - (size * (page-1)) > 0;
        if(!hasNextPage) return null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cateId", cateId);
        Util.addPageParam(map, size, page);
        return ss.selectList("com.codebee.stylehive.community.selectProductCate", map);
    }
}
