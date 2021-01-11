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
                if (field.getType().equals(BetDao.class)) {
                    BetDao betDao = Factory.getBetDao();
                    if (betDao.getClass().getAnnotation(Dao.class) != null) {
                        field.set(instance, Factory.getBetDao());
                    } else {
                        throw new AnnotationException("This class don't independents of "
                                + "Dao annotation"
                                + field.getClass());
                    }
                } else if (field.getType().equals(UserDao.class)) {
                    UserDao userDao = Factory.getUserDao();
                    if (userDao.getClass().getAnnotation(Dao.class) != null) {
                        field.set(instance, Factory.getUserDao());
                    } else {
                        throw new AnnotationException("This class don't independents of "
                                + "Dao annotation"
                                + field.getClass());
                    }
                }
            }
        }
        return instance;
    }
}
