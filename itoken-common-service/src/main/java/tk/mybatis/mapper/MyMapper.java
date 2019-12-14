package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author： kaider
 * @Date：2019/12/14 23:51
 * @描述：该接口不能被执行扫码到，否则会报错
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
