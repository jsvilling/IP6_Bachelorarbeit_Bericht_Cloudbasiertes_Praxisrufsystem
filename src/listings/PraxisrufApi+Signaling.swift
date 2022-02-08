protocol PraxisrufApiSignalingDelegate {
    func onConnectionLost()
    func onSignalReceived(_ signal: Signal)
    func onErrorReceived(error: Error)
}

extension PraxisrufApi {

    static var signalingDelegate: PraxisrufApiSignalingDelegate?

    private static var signalingWebSocket: URLSessionWebSocketTask? = nil;

    private var disconnected: Bool {
        ...
    }

    func connectSignalingServer(clientId: String) {
       ...
    }

    func disconnectSignalingService() {
        ...
    }

    func pingSignalingConnection() {
        ...
    }

    func sendSignal(signal: Signal) {
        ...
    }

    func listenForSignal() {
        ...
    }
}
