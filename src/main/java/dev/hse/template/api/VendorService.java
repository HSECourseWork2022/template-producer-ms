package dev.hse.template.api;

import dev.hse.template.pojo.TemplateRaw;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorService {

    public TemplateRaw fetchData() {
        // Do smth
        return TemplateRaw.builder().build();
    }

}
