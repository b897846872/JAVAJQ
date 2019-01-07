package com.blog.common;

import java.util.List;
import java.util.Map;


import com.blog.model.vo.TreeVo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 封装树结构
 * @author qi
 *
 */
public class TreeToolUtils {
	private List<TreeVo> rootList; //根节点对象存放到这里
    private List<TreeVo> bodyList; //其他节点存放到这里，可以包含根节点
    
    public TreeToolUtils(List<TreeVo> rootList, List<TreeVo> bodyList) {
        this.rootList = rootList;
        this.bodyList = bodyList;
    }
     
    /**
     * 获取树结构
     * @return
     */
    public List<TreeVo> getTree(){   //调用的方法入口
        if(bodyList != null && !bodyList.isEmpty()){
        //声明一个map，用来过滤已操作过的数据
            Map<String,String> map = Maps.newHashMapWithExpectedSize(bodyList.size());
            rootList.forEach(beanTree -> getChild(beanTree,map));
            return rootList;
        }
        return null;
    }

    private void getChild(TreeVo beanTree,Map<String,String> map){
        List<TreeVo> childList = Lists.newArrayList();
        bodyList.stream()
                .filter(c -> !map.containsKey(c.getId()))
                .filter(c ->c.getParentId().equals(beanTree.getId()))
                .forEach(c ->{
                    map.put(c.getId(),c.getParentId());
                    getChild(c,map);
                    childList.add(c);
                });
        beanTree.setChildren(childList);
    }
}
