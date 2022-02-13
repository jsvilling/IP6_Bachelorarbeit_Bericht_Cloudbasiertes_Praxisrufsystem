/**
 * Contracts for clients to register an intercom connection in Praxisruf
 * Once a connection is established it can be used, to negotiate messages between
 * registered clients. This enables signaling server functionality for when
 * establishing Peer To Peer Connections between clients.
 *
 * @param <T> Type of the connection
 * @param <M> Type of messages that will be exchanged
 */
public interface ClientConnector<T, M> {

    /**
     * Receives a message and forwards it to all relevant registered connections.
     * M is expected to contain the key any relevant connection.
     */
    void sendMessage(M message);

    /**
     * Is called after a connection has been established. The established connection
     * is stored in a ConnectionRegistry with key: clientId and value: connection.
     */
    void afterConnectionEstablished(UUID clientId, T connection);

    /**
     * Is called after a connection has been closed. The closed connection is
     * removed from the ConnectionRegistry.
     */
    void afterConnectionClosed(T connection);
}
