extension PraxisrufApi {
    func synthesize(authToken: String, completion: @escaping (Result<URL, PraxisrufApiError>) -> Void) {
        guard let audioUrl = URL(string: "\(baseUrlValue)/speechsynthesis") else {
            completion(.failure(.custom(errorMessage: "Invalid url configuration")))
            return
        }
        var request = URLRequest(url: audioUrl)
        request.addValue("Bearer \(authToken)", forHTTPHeaderField: "Authorization")
        URLSession.shared.downloadTask(with: request) { result, response, error in
            guard let audioFileLocation = result else {
                completion(.failure(.custom(errorMessage: "No audio received")))
                return
            }
            completion(.success(audioFileLocation))
        }.resume()
    }
}
