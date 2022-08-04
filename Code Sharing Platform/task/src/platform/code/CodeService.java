package platform.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeService {


    CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public void addCode(Code code) throws InterruptedException {
        codeRepository.save(code);
        //make sure to avoid the exact same dates in tests
        Thread.sleep(1000);
    }

    public Code getCodeById(Long id){
        return codeRepository.findById(id).get();

    }
    public List<Code> getLatest(){
        return codeRepository.findTop10ByOrderByDateDesc();
    }

}