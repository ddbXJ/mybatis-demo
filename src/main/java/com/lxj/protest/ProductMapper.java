package com.lxj.protest;

import java.util.List;

/**
 * Created by lixuejiao on 16/8/11.
 */
public interface ProductMapper {
    List<Integer> queryProductIds(ProductQueryDTO dto);
}
