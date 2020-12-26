package com.diarpy.platform;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Mack_TB
 * @version 1.0.7
 * @since 12/20/2020
 */


@RestController
@RequestMapping(path = "/api/code", produces = "application/json")
public class ApiController {

    private final CodeRepository codeRepository;

    public ApiController(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @PostMapping(path = "/new")
    public Object addCode(@RequestBody Code c) {
        Code code = new Code(c.getCode(), c.getTime(), c.getViews());
        code = codeRepository.save(code);
        return String.format("{ \"id\" : \"%s\" }", code.getId());
    }


    @GetMapping(path = "/{id}")
    public Code getCode(@PathVariable String id) {
        Code code;
        Optional<Code> optionalCode = codeRepository.findById(id);
        if (optionalCode.isPresent()) {
            code = optionalCode.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such Code");
        }

        restriction(codeRepository, code);

        code.setDate(Code.getFormattedDateTime(code.getDate()));
        return code;
    }

    private void restriction(CodeRepository codeRepository, Code code) {
        if (code.getTime() > 0) {
            if (code.getViews() > 0) {
                code.setViews(code.getViews() - 1);
                if (code.getViews() >= 0) {
                    codeRepository.save(code);
                }
            }
            long time = code.getTime();
            long codeTime = LocalDateTime.parse(code.getDate()).toLocalTime().toSecondOfDay();
            long timeForNow = LocalDateTime.now().toLocalTime().toSecondOfDay();
            code.setTime(time - (timeForNow - codeTime));
            if (code.getTime() <= 0 && code.getViews() == 0){
                codeRepository.deleteById(code.getId());
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such Code");
            }
        } else if (code.getViews() > 0) {
            code.setViews(code.getViews() - 1);
            if (code.getViews() > 0) {
                codeRepository.save(code);
            } else {
                codeRepository.deleteById(code.getId());
            }
        }
    }

    /**
     * @return JSON array with 10 most recently uploaded
     * code snippets sorted from the newest to the oldest.
     */
    @GetMapping(path = "/latest")
    public List<Code> getCodeList() {
        /*List<Code> subCodeList = codeRepository.findTop10();
        int j = 1;
        if (codeList.size() > 10) j = codeList.size() - 9;
        for (int i = codeList.size(); i >= j; i--) {
            subCodeList.add(codeList.get(i - 1));
        }*/
        List<Code> codes = codeRepository.findTop10ByTimeLessThanEqualAndViewsLessThanEqualOrderByDateDesc(0, 0);
        for (int i = 0; i < codes.size(); i++) {
            Code code = codes.remove(i);
            code.setDate(Code.getFormattedDateTime(code.getDate()));
            codes.add(i, code);
        }
        return codes;
    }

}
