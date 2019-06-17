package factory.management.system.project.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * MyCrud
 *
 * @author ngchunho
 * @version 1.0.0
 * @description 数据库crud操作类
 * @date 2019/6/17 16:55
 */
@NoArgsConstructor
@Data
public class MyCrud {

    private static MyMapper mapper;

    public static MyCrud of(MyMapper mapper) {
        MyCrud.mapper = mapper;
        return new MyCrud();
    }

    /**
     * 查询方法
     *
     * @return
     */
    public PageInfo<?> retrieve(/*HttpServletRequest request*/) {
        // 初始化分页
//        initPaging(request);
        PageHelper.startPage(1, 5);
        // 获取分页后的数据
        List<?> list = mapper.selectAll();
        // 获取分页信息
        PageInfo<?> pageInfo = new PageInfo<>(list);
        // 设置末页停留防止跳转至首页
        if (pageInfo.getNextPage() == 0) {
            pageInfo.setNextPage(pageInfo.getNavigateLastPage());
        }
        return pageInfo;
    }

    /**
     * 新增方法
     */
    @Transactional(rollbackFor = Exception.class)
    public void create(Object record) {
        try {
            // 新增实体
            mapper.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新方法
     */
    @Transactional(rollbackFor = Exception.class)
    public void update(Object record) {
        try {
            // 根据主键更新
            mapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除方法
     */
    @Transactional(rollbackFor = Exception.class)
    public void delete(Object key) {
        try {
            // 根据主键删除
            mapper.deleteByPrimaryKey(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}