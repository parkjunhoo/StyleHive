package com.codebee.stylehive.repository;

import com.codebee.stylehive.dto.CommunityDTO;
import com.codebee.stylehive.dto.ProductDTO;
import com.codebee.stylehive.jpa.entity.ImgThumbEntity;
import com.codebee.stylehive.jpa.entity.community.CommunityEntity;

import java.util.List;

public interface CommunityDAO {
    public CommunityDTO findById(int id);
    public List<CommunityDTO> findByProductId(int productId, int limit);
    public List<ImgThumbEntity> findImgByCommId(int commId);
    public int countByProductId(int productId);

    public List<ProductDTO> findTagProductByCommId(int commId);

    public int findByProductCateCount(int cateId);
    public List<CommunityDTO> findByProductCate(int cateId, int size, int page);
}
