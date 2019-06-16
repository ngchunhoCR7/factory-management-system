package factory.management.system.project.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * MyMapper
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/16 11:10
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
