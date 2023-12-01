package exercise;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static void main(String[] args) {
        Address address = new Address(null, "London", "1-st street", "7", "2");
        List<String> notValidFields = Validator.validate(address);
        System.out.println(notValidFields); // => [country]
    }

    public static List<String> validate(Object object) {
        List<String> result = new ArrayList<>();
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for(Field field : fields) {
            field.setAccessible(true);
            try {
                if(field.get(object) == null && field.getAnnotation(NotNull.class) != null) {
                    result.add(field.getName());
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
// END
