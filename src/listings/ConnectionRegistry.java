/**
 * Contracts for managing connections created by ClientConnector.
 * @param <T> Type of the connections
 */
public interface ConnectionRegistry<T> {

    /**
     * Registers the given connection in a key value store using clientId as key.
     * @return boolean - whether the registration is registered
     */
    boolean register(UUID clientId, T connection);

    /**
     * Removes the given connection from the key value store
     * @return boolean - whether the registration is unregistered
     */
    boolean unregister(T connection);
}
