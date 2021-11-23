@RestController
@RequestMapping("/api/speech")
@Api(tags = "Speech Synthesis")
@AllArgsConstructor
public class SpeechSynthesisController {

    private final SpeechSynthesisService service;

    @GetMapping(path = "/{id}", produces = "audio/mp3")
    public ResponseEntity synthesizeTestAudio(@PathVariable("id") UUID id) {
        InputStreamResource inputStreamResource = service.synthesize(id);
        return new ResponseEntity(inputStreamResource, HttpStatus.OK);
    }

}
