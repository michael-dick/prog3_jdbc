package package_student;

/**
 * Created by MichaelDick on 25/10/15.
 */
public interface DBConnection<KEY ,TYPE> {

    void connect();

    void disconnect();

    void persist(TYPE entity);

    void update(KEY identifier , TYPE mock);

    void delete(KEY identifier);
}
