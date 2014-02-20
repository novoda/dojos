import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by xrigau on 13/02/2014.
 */
public interface Breakable<T> {

    List<T> breakUp(Pattern pattern);
}
