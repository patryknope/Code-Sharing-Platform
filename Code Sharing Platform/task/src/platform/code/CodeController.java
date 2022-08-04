package platform.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CodeController {
    private CodeService codeService;

    @Autowired
    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(value = "/code/{id}")
    public String getCode(@PathVariable Long id, Model model) {
        model.addAttribute("title", "Code");
        Code code = codeService.getCodeById(id);
        model.addAttribute("codeSnippet", code.getCode());
        model.addAttribute("date", code.getDate());
        return "code_get";

    }

    @GetMapping(value = "/code/latest")
    public String getLatest(Model model) {
        model.addAttribute("title", "Latest");
        List<Code> codeSnippets = codeService.getLatest();
        model.addAttribute("codeSnippets", codeSnippets);
        return "code_latest";

    }

    @GetMapping(value = "/code/new", produces = MediaType.TEXT_HTML_VALUE)
    public String getNewCode() {
        return "code_create";
    }
}