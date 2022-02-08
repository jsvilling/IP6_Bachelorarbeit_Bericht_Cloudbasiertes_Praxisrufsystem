protocol CallClientDelegate {
    func send(_ signal: Signal)
    func updateState(clientId: String, state: String)
    func onIncommingCallPending(signal: Signal)
    func onIncomingCallDeclined(signal: Signal)
    func onCallEnded()
}
