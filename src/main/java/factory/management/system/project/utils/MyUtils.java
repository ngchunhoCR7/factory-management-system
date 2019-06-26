package factory.management.system.project.utils;

import com.github.pagehelper.PageHelper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.exportUtils.FieldEntity;
import factory.management.system.project.utils.exportUtils.FieldsCollector;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * MyUtils
 *
 * @author ngchunho
 * @version 1.0.0
 * @description 工具类
 * @date 2019/6/17 14:09
 */
public class MyUtils {

    /**
     * 自定义分页工具类
     */
    public static class PageUtils {

        /**
         * 默认分页页码
         */
        private static int PAGE_NUM = 1;

        /**
         * 默认分页条数
         */
        private static int PAGE_SIZE = 10;

        static PageUtils of(Integer pageNum, Integer pageSize) {
            PageUtils.PAGE_NUM = pageNum;
            PageUtils.PAGE_SIZE = pageSize;
            return new PageUtils();
        }

        /**
         * 初始化分页
         *
         * @param pageSizeInfo
         */
        public static void initPaging(PageSizeInfo pageSizeInfo) {
            // 设置当前页码
            int pageNum = getPage(pageSizeInfo);
            // 设置每页显示数量
            int pageSize = getSize(pageSizeInfo);
            // 设置分页信息
            PageHelper.startPage(pageNum, pageSize);
        }

        /**
         * 获取查询的页码
         *
         * @param pageSizeInfo
         * @return currentPage 当前页码
         */
        private static int getPage(PageSizeInfo pageSizeInfo) {
            // 获取参数
            int pageNum;

            // 判断是否为空
            if (isEmpty(pageSizeInfo.getPageNum())) {
                pageNum = PAGE_NUM;
            } else {
                pageNum = pageSizeInfo.getPageNum();
            }

            return pageNum;
        }

        /**
         * 获取每页查询的条数
         *
         * @param pageSizeInfo
         * @return size 每页查询的条数
         */
        private static int getSize(PageSizeInfo pageSizeInfo) {
            // 获取参数
            int pageSize;

            // 判断是否为空
            if (isEmpty(pageSizeInfo.getPageSize())) {
                pageSize = PAGE_SIZE;
            } else {
                pageSize = pageSizeInfo.getPageSize();
            }

            return pageSize;
        }
    }

    /**
     * 自定义时间工具类
     */
    public static class DateUtils {

        /**
         * 获取当前 Date
         *
         * @return
         */
        public static Date getDate() {
            // 获取当前时间
            LocalDateTime localDateTime = LocalDateTime.now();
            // 获取时间地区ID
            ZoneId zoneId = ZoneId.systemDefault();
            return Date.from(localDateTime.atZone(zoneId).toInstant());
        }

        /**
         * 获取当前 Datetime
         *
         * @return
         */
        public static Date getDateTime() {
            // 设置时区
            return Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("+8")));
        }

        /**
         * 获取当前 Date 的 String
         *
         * @return
         */
        public static String getDateString() {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.now().format(df);
        }

        /**
         * 获取当前 Datetime 的 String
         *
         * @return
         */
        public static String getDateTimeString() {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.now().format(df);
        }

        /**
         * @param date
         * @return
         */
        public static LocalDate setDate(Date date) {
            // 获取date实例
            Instant instant = date.toInstant();
            // 设置时区
            ZoneId zone = ZoneId.systemDefault();
            // 转为LocalDateTime
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
            return localDateTime.toLocalDate();
        }

        /**
         * @param date
         * @return
         */
        public static LocalDateTime setDateTime(Date date) {
            // 获取date实例
            Instant instant = date.toInstant();
            // 设置时区
            ZoneId zone = ZoneId.systemDefault();
            return LocalDateTime.ofInstant(instant, zone);
        }
    }

    /**
     * 获取 Example
     *
     * @param entityClass 实体类
     * @param property    对象参数
     * @param value       设置值
     * @return 设置规则后的 example
     */
    public static Example getExample(Class<?> entityClass, String property, Object value) {
        Example example = new Example(entityClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(property, value);
        return example;
    }

    /**
     * 获取倒序排序后的 Example
     *
     * @param entityClass 实体类
     * @param property    对象参数
     * @return 倒序排序后的 example
     */
    public static Example getExampleDesc(Class<?> entityClass, String property) {
        Example example = new Example(entityClass);
        example.orderBy(property).desc();
        return example;
    }

    /**
     * 判断object是否为空
     *
     * @param object 泛型
     * @return true or false
     */
    private static boolean isEmpty(Object object) {
        return StringUtils.isEmpty(object);
    }

    /**
     * 导出表格工具类
     *
     * @param response HttpServletResponse响应报文
     * @param fileName 文件名
     * @param dataList 数据库的数据列表
     */
    public static void exportExcel(HttpServletResponse response, String fileName, List<?> dataList) {
        // 创建poi导出数据对象
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        // 创建sheet页
        SXSSFSheet sheet = workbook.createSheet();
        // 创建表头
        SXSSFRow headRow = sheet.createRow(0);

        try {
            // 解析一个实体数据
            Map<String, FieldEntity> map = FieldsCollector.getFileds(dataList.get(0));
            Set<String> set = map.keySet();
            // 创建表头信息
            int index = 0;
            for (String string : set) {
                headRow.createCell(index++).setCellValue(string);
            }

            // 遍历数据库数据
            for (Object object : dataList) {
                // 创建数据行
                SXSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
                // 解析一个实体数据
                map = FieldsCollector.getFileds(object);
                // 对实体进行遍历
                index = 0;
                for (String string : map.keySet()) {
                    // 填充数据
                    dataRow.createCell(index++).setCellValue(map.get(string).getValue().toString());
                }
            }

            // 下载导出
            String filename = fileName;
            // 设置响应头信息
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/vnd.ms-excel");
            // 设置成xlsx格式
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename + ".xlsx", "UTF-8"));
            // 创建输出流
            ServletOutputStream outputStream = response.getOutputStream();
            // 写入数据
            workbook.write(outputStream);
            // 关闭流
            outputStream.close();
            workbook.close();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
