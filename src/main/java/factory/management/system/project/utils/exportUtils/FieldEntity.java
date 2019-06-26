package factory.management.system.project.utils.exportUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * FieldEntity
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/26 15:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldEntity {

    /**
     * field name
     **/
    private String fieldname;

    /**
     * field value
     **/
    private Object value;

    /**
     * field value's class type
     **/
    private Class clazz;

    private List<String> errorMsg = new ArrayList<String>();

    public FieldEntity(String fieldname, Object value, Class clazz) {
        super();
        this.fieldname = fieldname;
        this.value = value;
        this.clazz = clazz;
    }

    private FieldEntity(String fieldname, List<String> errorMsg) {
        super();
        this.fieldname = fieldname;
        this.errorMsg = errorMsg;
    }
}
