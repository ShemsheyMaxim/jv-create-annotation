package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.AnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                Object object;
                if (field.getType().equals(BetDao.class)) {
                    object = Factory.getBetDao();
                    checkObjectOnAnnotationDao(field, object);
                    field.set(instance, object);
                } else if (field.getType().equals(UserDao.class)) {
                    object = Factory.getUserDao();
                    checkObjectOnAnnotationDao(field, object);
                    field.set(instance, object);
                }
            }
        }
        return instance;
    }

    private static void checkObjectOnAnnotationDao(Field field, Object object) {
        if (object.getClass().getAnnotation(Dao.class) == null) {
            throw new AnnotationException("This class don't independents of "
                    + "Dao annotation"
                    + field.getClass());
        }
    }
}
