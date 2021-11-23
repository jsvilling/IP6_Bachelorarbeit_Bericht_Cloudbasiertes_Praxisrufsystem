/**
 * Contracts for getting speech synthesis data from a speech synthesis provider.
 */
public interface SpeechSynthesisService {

    /**
     * Requests the NotificationType with the given id from the configuration
     * and then sends a request to a speech synthesis provider.
     *
     * The result from the provider is written into a InputStreamResource
     * containing MP3 audio data.
     */
    InputStreamResource synthesize(UUID id);

}
