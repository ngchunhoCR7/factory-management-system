package factory.management.system.project.utils.exportUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * FieldsCollector
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/26 15:29
 */
public class FieldsCollector {
    public static Map<String, FieldEntity> getFileds(Object object)
            throws SecurityException, IllegalArgumentException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Map<String, FieldEntity> map = new HashMap<String, FieldEntity>();

        for (int i = 0; i < fields.length; i++) {

            Object resultObject = invokeMethod(object, fields[i].getName(), null);
            map.put(fields[i].getName(), new FieldEntity(fields[i].getName(), resultObject, fields[i].getType()));
        }

        return map;
    }

    public static Object invokeMethod(Object owner, String fieldname,
                                      Object[] args) throws SecurityException, NoSuchMethodException,
            IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Class ownerClass = owner.getClass();

        Method method = null;
        method = ownerClass.getMethod(GetterUtil.toGetter(fieldname));

        Object object = null;
        object = method.invoke(owner);

        return object;
    }

}
