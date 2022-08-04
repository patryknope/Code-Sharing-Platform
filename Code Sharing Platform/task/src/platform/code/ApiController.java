package platform.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ApiController {
    private final CodeService codeService;

    @Autowired
    public ApiController( CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(value = "/api/code/{id}")
    public Code getCodeById(@PathVariable Long id) {
        return codeService.getCodeById(id);
    }

    @GetMapping(value = "/api/code/latest", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Code> getApiCode() {
        return codeService.getLatest();
    }

    @PostMapping(value = "/api/code/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String postApiNewCode(@RequestBody Code code) throws InterruptedException {
        codeService.addCode(code);
        return String.format("{ \"id\" : \"%s\" }", code.getId());
    }
}