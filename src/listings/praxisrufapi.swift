typealias CompletionHandler<T> = (Result<T, PraxisrufApiError>) -> Void

class PraxisrufApi {

    static let httpBaseUrlValue = ...

    func get<T>(_ subUrl: String,
                completion: @escaping CompletionHandler<T>) where T : Decodable {

        http(subUrl, completion: completion)
    }

    func post<T>(_ subUrl: String,
                 body: Data? = nil,
                 completion: @escaping CompletionHandler<T>) where T : Decodable {

        http(subUrl, method: "POST", body: body, completion: completion)
    }

    func delete<T>(_ subUrl: String,
                   completion: @escaping CompletionHandler<T>) where T : Decodable {

        http(subUrl, method: "DELETE", completion: completion)
    }

    func download(_ subUrl: String,
                  completion: @escaping CompletionHandler<T>) { ... }

    func http<T>(_ subUrl: String,
                 method: String = "GET",
                 body: Data? = nil,
                 completion: @escaping CompletionHandler<T>) where T : Decodable { ... }

}
