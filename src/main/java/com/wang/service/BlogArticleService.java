package com.wang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.mapper.BlogArticleMapper;
import com.wang.pojo.BlogArticle;
import com.wang.utils.PageRequest;
import com.wang.utils.PageResult;
import com.wang.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Evan
 * @date 2020/1/14 21:00
 */
@Service
public class BlogArticleService {
    @Autowired
    BlogArticleMapper blogArticleMapper;

    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     */
    private PageInfo<BlogArticle> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<BlogArticle> blogArticles = blogArticleMapper.selectPage();
        return new PageInfo<BlogArticle>(blogArticles);
    }



//    public MyPage list(int page, int size) {
//        MyPage<JotterArticle> articles;
//        String key = "articlepage:" + page;
//        Object articlePageCache = redisService.get(key);
//
//        if (articlePageCache == null) {
//            Sort sort = Sort.by(Sort.Direction.DESC, "id");
//            Page<JotterArticle> articlesInDb = jotterArticleMapper.findAll(PageRequest.of(page, size, sort));
//            articles = new MyPage<>(articlesInDb);
//            redisService.set(key, articles);
//        } else {
//            articles = (MyPage<JotterArticle>) articlePageCache;
//        }
//        return articles;
//    }

//    用于复现异常
//    @Cacheable(value = RedisConfig.REDIS_KEY_DATABASE)
//    public Page list(int page, int size) {
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        return jotterArticleDAO.findAll(PageRequest.of(page, size, sort));
//    }


//    public JotterArticle findById(int id) {
//        JotterArticle article;
//        String key = "article:" + id;
//        Object articleCache = redisService.get(key);
//
//        if (articleCache == null) {
//            article = jotterArticleMapper.findById(id);
//            redisService.set(key, article);
//        } else {
//            article = (JotterArticle) articleCache;
//        }
//        return article;
//    }
//
//    public void addOrUpdate(JotterArticle article) {
//        jotterArticleMapper.save(article);
//
//        redisService.delete("article" + article.getId());
//        Set<String> keys = redisService.getKeysByPattern("articlepage*");
//        redisService.delete(keys);
//    }
//
//    public void delete(int id) {
//        jotterArticleMapper.deleteById(id);
//
//        redisService.delete("article:" + id);
//        Set<String> keys = redisService.getKeysByPattern("articlepage*");
//        redisService.delete(keys);
//    }
}
